package com.etlsolutions.dataretrieval.view;

import com.etlsolutions.dataretrieval.model.CustomerInfo;
import com.etlsolutions.dataretrieval.model.CustomerInvoicesInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.etlsolutions.dataretrieval.model.InvoiceInfo;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;

public class RssFeedView extends AbstractRssFeedView {

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
            HttpServletRequest request) {

        feed.setTitle("Sample Title");
        feed.setDescription("Sample Description");
        feed.setLink("http://google.com");

        super.buildFeedMetadata(model, feed, request);
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        CustomerInfo customerInfo = (CustomerInfo) model.get("customerInfo");
        InvoiceInfo invoiceInfo = (InvoiceInfo) model.get("invoiceInfo");
        CustomerInvoicesInfo customerInvoicesInfo = (CustomerInvoicesInfo) model.get("customerInvoicesInfo");

        String msg;
        if (customerInfo != null) {
            msg = "ID: " + customerInfo.getId() + "/Name: " + customerInfo.getName();
        } else if (invoiceInfo != null) {
            msg = "ID: " + invoiceInfo.getId() + "/Amount: " + invoiceInfo.getAmount();
        } else if (customerInvoicesInfo != null) {
            customerInfo = customerInvoicesInfo.getCustomerInfo();
            msg = "ID: " + customerInfo.getId() + "/Name: " + customerInfo.getName();
        } else {
            msg = "invalid id";
        }

        List<Item> items = new ArrayList<>(1);
        Item item = new Item();

        item.setAuthor("Zhipeng Chang");
        item.setLink("http://www.etlsolutions.com");

        Content content = new Content();

        content.setValue(msg);

        item.setContent(content);

        items.add(item);

        return items;
    }

}
