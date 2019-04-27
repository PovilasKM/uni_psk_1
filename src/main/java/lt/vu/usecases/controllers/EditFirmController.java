package lt.vu.usecases.controllers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Firm;
import lt.vu.usecases.dao.FirmDAO;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Slf4j
public class EditFirmController implements Serializable {

    @Getter
    private Firm selectedFirm;
    @Getter
    private Firm conflictingFirm;
    @Getter
    private List<Firm> allFirms;

    @Inject
    private FirmDAO firmDAO;

    @PostConstruct
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Firm firm) {
        selectedFirm = firm;
        conflictingFirm = null;
    }

    @Transactional
    public void updateSelectedFirm() {
        try {
            firmDAO.updateAndFlush(selectedFirm);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingFirm = firmDAO.findById(selectedFirm.getId());
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void overwriteFirm() {
        selectedFirm.setOptLockVersion(conflictingFirm.getOptLockVersion());
        updateSelectedFirm();
    }

    public void reloadAll() {
        allFirms = firmDAO.getAllFirms();
    }
}
