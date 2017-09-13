package com.company.sample.web.customer;

import com.company.sample.entity.Customer;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerBrowse extends AbstractLookup {
    @Inject
    private GroupDatasource<Customer, UUID> customersDs;
    @Inject
    private PieChart pieChart;

    @Override
    public void init(Map<String, Object> params) {
        customersDs.addCollectionChangeListener(e -> {
            List<DataItem> items = customersDs.getItems().stream()
                    .collect(Collectors.groupingBy(Customer::getGrade, Collectors.counting()))
                    .entrySet().stream()
                    .map(entry -> new MapDataItem(ParamsMap.of("grade", entry.getKey(), "count", entry.getValue())))
                    .collect(Collectors.toList());

            DataProvider dataProvider = new ListDataProvider(items);
            pieChart.setDataProvider(dataProvider);
        });
    }
}