package com.etlsolutions.examples.mainwebapp.controller;



import com.etlsolutions.examples.mainwebapp.controller.util.JsfUtil;
import com.etlsolutions.examples.mainwebapp.controller.util.PaginationHelper;
import com.etlsolutions.examples.mainwebapp.entity.ItemCommonDetail;
import com.etlsolutions.examples.mainwebapp.facade.ItemCommonDetailFacade;
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

@Named("itemController")
@SessionScoped
public class ItemCommonDetailController implements Serializable {

    private ItemCommonDetail current;
    private DataModel itemCommonDetails = null;
    @EJB
    private com.etlsolutions.examples.mainwebapp.facade.ItemCommonDetailFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ItemCommonDetailController() {
    }

    public ItemCommonDetail getSelected() {
        if (current == null) {
            current = new ItemCommonDetail();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ItemCommonDetailFacade getFacade() {
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
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
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
        current = (ItemCommonDetail) getItemCommonDetails().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItemCommonDetails().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ItemCommonDetail();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ItemCommonDetail) getItemCommonDetails().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItemCommonDetails().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ItemCommonDetail) getItemCommonDetails().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItemCommonDetails().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItemCommonDetail();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all itemCommonDetails were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItemCommonDetail() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of itemCommonDetails:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItemCommonDetails() {
        if (itemCommonDetails == null) {
            itemCommonDetails = getPagination().createPageDataModel();
        }
        return itemCommonDetails;
    }

    private void recreateModel() {
        itemCommonDetails = null;
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

    public ItemCommonDetail getItemCommonDetail(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ItemCommonDetail.class)
    public static class ItemControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ItemCommonDetailController controller = (ItemCommonDetailController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "itemController");
            return controller.getItemCommonDetail(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(int value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ItemCommonDetail) {
                ItemCommonDetail o = (ItemCommonDetail) object;
                return getStringKey(o.getItemCommonDetailId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ItemCommonDetail.class.getName());
            }
        }

    }

}
