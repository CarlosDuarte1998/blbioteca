package com.mycompany.controllers;

import com.mycompany.entities.Prestamo;
import com.mycompany.controllers.util.JsfUtil;
import com.mycompany.controllers.util.PaginationHelper;
import com.mycompany.services.PrestamoFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("prestamoController")
@SessionScoped
public class PrestamoController implements Serializable {

    private Prestamo current;
    private DataModel<Prestamo> items = null;

    @EJB
    private PrestamoFacade ejbFacade;

    private PaginationHelper pagination;
    private int selectedItemIndex;

    public PrestamoController() {
    }

    public Prestamo getSelected() {
        if (current == null) {
            current = new Prestamo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PrestamoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel<Prestamo> createPageDataModel() {
                    return new ListDataModel<>(getFacade().findRange(new int[]{
                        getPageFirstItem(), getPageFirstItem() + getPageSize()
                    }));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = items.getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + items.getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Prestamo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PrestamoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = items.getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + items.getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PrestamoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = items.getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + items.getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        return selectedItemIndex >= 0 ? "View" : "List";
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PrestamoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            selectedItemIndex = count - 1;
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel<Prestamo> getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Prestamo getPrestamo(Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Prestamo.class)
    public static class PrestamoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                return null;
            }
            PrestamoController controller = (PrestamoController) facesContext.getApplication().getELResolver()
                    .getValue(facesContext.getELContext(), null, "prestamoController");
            return controller.getPrestamo(Integer.valueOf(value));
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Prestamo) {
                Prestamo o = (Prestamo) object;
                return o.getIdPrestamo() != null ? o.getIdPrestamo().toString() : "";
            } else {
                throw new IllegalArgumentException("Objeto " + object + " es de tipo " + object.getClass().getName()
                        + "; se esperaba tipo: " + Prestamo.class.getName());
            }
        }
    }
}
