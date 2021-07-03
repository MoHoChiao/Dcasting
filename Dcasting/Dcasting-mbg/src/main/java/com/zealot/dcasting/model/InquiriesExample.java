package com.zealot.dcasting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InquiriesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InquiriesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andInquiryIdIsNull() {
            addCriterion("inquiry_id is null");
            return (Criteria) this;
        }

        public Criteria andInquiryIdIsNotNull() {
            addCriterion("inquiry_id is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryIdEqualTo(String value) {
            addCriterion("inquiry_id =", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotEqualTo(String value) {
            addCriterion("inquiry_id <>", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdGreaterThan(String value) {
            addCriterion("inquiry_id >", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdGreaterThanOrEqualTo(String value) {
            addCriterion("inquiry_id >=", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdLessThan(String value) {
            addCriterion("inquiry_id <", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdLessThanOrEqualTo(String value) {
            addCriterion("inquiry_id <=", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdLike(String value) {
            addCriterion("inquiry_id like", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotLike(String value) {
            addCriterion("inquiry_id not like", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdIn(List<String> values) {
            addCriterion("inquiry_id in", values, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotIn(List<String> values) {
            addCriterion("inquiry_id not in", values, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdBetween(String value1, String value2) {
            addCriterion("inquiry_id between", value1, value2, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotBetween(String value1, String value2) {
            addCriterion("inquiry_id not between", value1, value2, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdIsNull() {
            addCriterion("inquiry_user_id is null");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdIsNotNull() {
            addCriterion("inquiry_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdEqualTo(Long value) {
            addCriterion("inquiry_user_id =", value, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdNotEqualTo(Long value) {
            addCriterion("inquiry_user_id <>", value, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdGreaterThan(Long value) {
            addCriterion("inquiry_user_id >", value, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inquiry_user_id >=", value, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdLessThan(Long value) {
            addCriterion("inquiry_user_id <", value, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdLessThanOrEqualTo(Long value) {
            addCriterion("inquiry_user_id <=", value, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdIn(List<Long> values) {
            addCriterion("inquiry_user_id in", values, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdNotIn(List<Long> values) {
            addCriterion("inquiry_user_id not in", values, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdBetween(Long value1, Long value2) {
            addCriterion("inquiry_user_id between", value1, value2, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryUserIdNotBetween(Long value1, Long value2) {
            addCriterion("inquiry_user_id not between", value1, value2, "inquiryUserId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdIsNull() {
            addCriterion("inquiry_group_id is null");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdIsNotNull() {
            addCriterion("inquiry_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdEqualTo(Long value) {
            addCriterion("inquiry_group_id =", value, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdNotEqualTo(Long value) {
            addCriterion("inquiry_group_id <>", value, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdGreaterThan(Long value) {
            addCriterion("inquiry_group_id >", value, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inquiry_group_id >=", value, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdLessThan(Long value) {
            addCriterion("inquiry_group_id <", value, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("inquiry_group_id <=", value, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdIn(List<Long> values) {
            addCriterion("inquiry_group_id in", values, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdNotIn(List<Long> values) {
            addCriterion("inquiry_group_id not in", values, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdBetween(Long value1, Long value2) {
            addCriterion("inquiry_group_id between", value1, value2, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andInquiryGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("inquiry_group_id not between", value1, value2, "inquiryGroupId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductQuantityIsNull() {
            addCriterion("product_quantity is null");
            return (Criteria) this;
        }

        public Criteria andProductQuantityIsNotNull() {
            addCriterion("product_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andProductQuantityEqualTo(Integer value) {
            addCriterion("product_quantity =", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityNotEqualTo(Integer value) {
            addCriterion("product_quantity <>", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityGreaterThan(Integer value) {
            addCriterion("product_quantity >", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_quantity >=", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityLessThan(Integer value) {
            addCriterion("product_quantity <", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("product_quantity <=", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityIn(List<Integer> values) {
            addCriterion("product_quantity in", values, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityNotIn(List<Integer> values) {
            addCriterion("product_quantity not in", values, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityBetween(Integer value1, Integer value2) {
            addCriterion("product_quantity between", value1, value2, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("product_quantity not between", value1, value2, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIsNull() {
            addCriterion("service_category is null");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIsNotNull() {
            addCriterion("service_category is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryEqualTo(String value) {
            addCriterion("service_category =", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotEqualTo(String value) {
            addCriterion("service_category <>", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryGreaterThan(String value) {
            addCriterion("service_category >", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("service_category >=", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLessThan(String value) {
            addCriterion("service_category <", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLessThanOrEqualTo(String value) {
            addCriterion("service_category <=", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLike(String value) {
            addCriterion("service_category like", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotLike(String value) {
            addCriterion("service_category not like", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIn(List<String> values) {
            addCriterion("service_category in", values, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotIn(List<String> values) {
            addCriterion("service_category not in", values, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryBetween(String value1, String value2) {
            addCriterion("service_category between", value1, value2, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotBetween(String value1, String value2) {
            addCriterion("service_category not between", value1, value2, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(String value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(String value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(String value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(String value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(String value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLike(String value) {
            addCriterion("payment like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotLike(String value) {
            addCriterion("payment not like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<String> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<String> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(String value1, String value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(String value1, String value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andRequirementDateIsNull() {
            addCriterion("requirement_date is null");
            return (Criteria) this;
        }

        public Criteria andRequirementDateIsNotNull() {
            addCriterion("requirement_date is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementDateEqualTo(Date value) {
            addCriterion("requirement_date =", value, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateNotEqualTo(Date value) {
            addCriterion("requirement_date <>", value, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateGreaterThan(Date value) {
            addCriterion("requirement_date >", value, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateGreaterThanOrEqualTo(Date value) {
            addCriterion("requirement_date >=", value, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateLessThan(Date value) {
            addCriterion("requirement_date <", value, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateLessThanOrEqualTo(Date value) {
            addCriterion("requirement_date <=", value, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateIn(List<Date> values) {
            addCriterion("requirement_date in", values, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateNotIn(List<Date> values) {
            addCriterion("requirement_date not in", values, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateBetween(Date value1, Date value2) {
            addCriterion("requirement_date between", value1, value2, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andRequirementDateNotBetween(Date value1, Date value2) {
            addCriterion("requirement_date not between", value1, value2, "requirementDate");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNull() {
            addCriterion("shipping_address is null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNotNull() {
            addCriterion("shipping_address is not null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressEqualTo(String value) {
            addCriterion("shipping_address =", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotEqualTo(String value) {
            addCriterion("shipping_address <>", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThan(String value) {
            addCriterion("shipping_address >", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_address >=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThan(String value) {
            addCriterion("shipping_address <", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThanOrEqualTo(String value) {
            addCriterion("shipping_address <=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLike(String value) {
            addCriterion("shipping_address like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotLike(String value) {
            addCriterion("shipping_address not like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIn(List<String> values) {
            addCriterion("shipping_address in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotIn(List<String> values) {
            addCriterion("shipping_address not in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressBetween(String value1, String value2) {
            addCriterion("shipping_address between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotBetween(String value1, String value2) {
            addCriterion("shipping_address not between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShipmentIsNull() {
            addCriterion("shipment is null");
            return (Criteria) this;
        }

        public Criteria andShipmentIsNotNull() {
            addCriterion("shipment is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentEqualTo(String value) {
            addCriterion("shipment =", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentNotEqualTo(String value) {
            addCriterion("shipment <>", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentGreaterThan(String value) {
            addCriterion("shipment >", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentGreaterThanOrEqualTo(String value) {
            addCriterion("shipment >=", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentLessThan(String value) {
            addCriterion("shipment <", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentLessThanOrEqualTo(String value) {
            addCriterion("shipment <=", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentLike(String value) {
            addCriterion("shipment like", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentNotLike(String value) {
            addCriterion("shipment not like", value, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentIn(List<String> values) {
            addCriterion("shipment in", values, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentNotIn(List<String> values) {
            addCriterion("shipment not in", values, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentBetween(String value1, String value2) {
            addCriterion("shipment between", value1, value2, "shipment");
            return (Criteria) this;
        }

        public Criteria andShipmentNotBetween(String value1, String value2) {
            addCriterion("shipment not between", value1, value2, "shipment");
            return (Criteria) this;
        }

        public Criteria andPackingIsNull() {
            addCriterion("packing is null");
            return (Criteria) this;
        }

        public Criteria andPackingIsNotNull() {
            addCriterion("packing is not null");
            return (Criteria) this;
        }

        public Criteria andPackingEqualTo(String value) {
            addCriterion("packing =", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotEqualTo(String value) {
            addCriterion("packing <>", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingGreaterThan(String value) {
            addCriterion("packing >", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingGreaterThanOrEqualTo(String value) {
            addCriterion("packing >=", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLessThan(String value) {
            addCriterion("packing <", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLessThanOrEqualTo(String value) {
            addCriterion("packing <=", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingLike(String value) {
            addCriterion("packing like", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotLike(String value) {
            addCriterion("packing not like", value, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingIn(List<String> values) {
            addCriterion("packing in", values, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotIn(List<String> values) {
            addCriterion("packing not in", values, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingBetween(String value1, String value2) {
            addCriterion("packing between", value1, value2, "packing");
            return (Criteria) this;
        }

        public Criteria andPackingNotBetween(String value1, String value2) {
            addCriterion("packing not between", value1, value2, "packing");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusIsNull() {
            addCriterion("inquiry_status is null");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusIsNotNull() {
            addCriterion("inquiry_status is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusEqualTo(String value) {
            addCriterion("inquiry_status =", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusNotEqualTo(String value) {
            addCriterion("inquiry_status <>", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusGreaterThan(String value) {
            addCriterion("inquiry_status >", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusGreaterThanOrEqualTo(String value) {
            addCriterion("inquiry_status >=", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusLessThan(String value) {
            addCriterion("inquiry_status <", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusLessThanOrEqualTo(String value) {
            addCriterion("inquiry_status <=", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusLike(String value) {
            addCriterion("inquiry_status like", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusNotLike(String value) {
            addCriterion("inquiry_status not like", value, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusIn(List<String> values) {
            addCriterion("inquiry_status in", values, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusNotIn(List<String> values) {
            addCriterion("inquiry_status not in", values, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusBetween(String value1, String value2) {
            addCriterion("inquiry_status between", value1, value2, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andInquiryStatusNotBetween(String value1, String value2) {
            addCriterion("inquiry_status not between", value1, value2, "inquiryStatus");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Long value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Long value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Long value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Long value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Long> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Long> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("update_datetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("update_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("update_datetime =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("update_datetime <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("update_datetime >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_datetime >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("update_datetime <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("update_datetime <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("update_datetime in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("update_datetime not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("update_datetime between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("update_datetime not between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }
        
        public Criteria multiColumnOrClause(Map<String, String> map) {
        	StringBuffer sb = new StringBuffer();
        	int i = 0;
        	sb.append("( ");
        	for(String column : map.keySet()) {
        		if (i != 0) {
        			sb.append(" OR ");
        		}
        		sb.append(column + " like '%" + map.get(column)  + "%'");
        		i++;
        	}
        	sb.append(" )");
            addCriterion(sb.toString());
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}