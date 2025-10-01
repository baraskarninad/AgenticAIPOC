package com.pstore.controllers;

import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.catalog.model.ProductFeatureModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class CartPageController {
    private static final Logger LOG = LogManager.getLogger(CartPageController.class);

    public void processProductFeature(ProductFeatureModel feature) {
        if (feature == null) {
            LOG.warn("ProductFeatureModel is null");
            return;
        }
        ClassAttributeAssignmentModel assignment = feature.getClassificationAttributeAssignment();
        ClassificationClassModel classModel = null;
        if (assignment != null) {
            classModel = assignment.getClassificationClass();
        } else {
            LOG.error("ClassificationAttributeAssignment is null for feature with PK: " + feature.getPk());
            return;
        }
        Object valueObj = feature.getValue();
        String value = null;
        if (valueObj == null) {
            LOG.error("Feature value is null for attribute: " + (assignment.getCode() != null ? assignment.getCode() : "unknown"));
            return;
        }
        if (assignment.getCode() != null && ("CAT_ITEM_RF_Connectors_Gender".equals(assignment.getCode()) || "CAT_ITEM_RF_Connectors_ST".equals(assignment.getCode()))) {
            if (valueObj instanceof String) {
                value = (String) valueObj;
            } else {
                LOG.error("Invalid data type for property " + assignment.getCode() + ", expected String but found " + valueObj.getClass().getSimpleName());
                value = valueObj.toString();
            }
        } else {
            value = valueObj.toString();
        }
        // Further processing, e.g. indexing
        // try {
        //     solrService.indexProductFeature(feature);
        // } catch (SolrServerException e) {
        //     LOG.error("Failed to connect to Solr: " + e.getMessage());
        //     // Could implement retry logic here
        // }
    }
}
