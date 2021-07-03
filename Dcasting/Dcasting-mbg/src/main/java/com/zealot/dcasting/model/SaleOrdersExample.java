package com.zealot.dcasting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SaleOrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleOrdersExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andSapIdIsNull() {
            addCriterion("sap_id is null");
            return (Criteria) this;
        }

        public Criteria andSapIdIsNotNull() {
            addCriterion("sap_id is not null");
            return (Criteria) this;
        }

        public Criteria andSapIdEqualTo(String value) {
            addCriterion("sap_id =", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotEqualTo(String value) {
            addCriterion("sap_id <>", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdGreaterThan(String value) {
            addCriterion("sap_id >", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdGreaterThanOrEqualTo(String value) {
            addCriterion("sap_id >=", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdLessThan(String value) {
            addCriterion("sap_id <", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdLessThanOrEqualTo(String value) {
            addCriterion("sap_id <=", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdLike(String value) {
            addCriterion("sap_id like", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotLike(String value) {
            addCriterion("sap_id not like", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdIn(List<String> values) {
            addCriterion("sap_id in", values, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotIn(List<String> values) {
            addCriterion("sap_id not in", values, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdBetween(String value1, String value2) {
            addCriterion("sap_id between", value1, value2, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotBetween(String value1, String value2) {
            addCriterion("sap_id not between", value1, value2, "sapId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIsNull() {
            addCriterion("delivery_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIsNotNull() {
            addCriterion("delivery_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdEqualTo(String value) {
            addCriterion("delivery_id =", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotEqualTo(String value) {
            addCriterion("delivery_id <>", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThan(String value) {
            addCriterion("delivery_id >", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_id >=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThan(String value) {
            addCriterion("delivery_id <", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThanOrEqualTo(String value) {
            addCriterion("delivery_id <=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLike(String value) {
            addCriterion("delivery_id like", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotLike(String value) {
            addCriterion("delivery_id not like", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIn(List<String> values) {
            addCriterion("delivery_id in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotIn(List<String> values) {
            addCriterion("delivery_id not in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdBetween(String value1, String value2) {
            addCriterion("delivery_id between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotBetween(String value1, String value2) {
            addCriterion("delivery_id not between", value1, value2, "deliveryId");
            return (Criteria) this;
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

        public Criteria andInquiryNameIsNull() {
            addCriterion("inquiry_name is null");
            return (Criteria) this;
        }

        public Criteria andInquiryNameIsNotNull() {
            addCriterion("inquiry_name is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryNameEqualTo(String value) {
            addCriterion("inquiry_name =", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameNotEqualTo(String value) {
            addCriterion("inquiry_name <>", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameGreaterThan(String value) {
            addCriterion("inquiry_name >", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameGreaterThanOrEqualTo(String value) {
            addCriterion("inquiry_name >=", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameLessThan(String value) {
            addCriterion("inquiry_name <", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameLessThanOrEqualTo(String value) {
            addCriterion("inquiry_name <=", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameLike(String value) {
            addCriterion("inquiry_name like", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameNotLike(String value) {
            addCriterion("inquiry_name not like", value, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameIn(List<String> values) {
            addCriterion("inquiry_name in", values, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameNotIn(List<String> values) {
            addCriterion("inquiry_name not in", values, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameBetween(String value1, String value2) {
            addCriterion("inquiry_name between", value1, value2, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andInquiryNameNotBetween(String value1, String value2) {
            addCriterion("inquiry_name not between", value1, value2, "inquiryName");
            return (Criteria) this;
        }

        public Criteria andQuotationIdIsNull() {
            addCriterion("quotation_id is null");
            return (Criteria) this;
        }

        public Criteria andQuotationIdIsNotNull() {
            addCriterion("quotation_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuotationIdEqualTo(String value) {
            addCriterion("quotation_id =", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdNotEqualTo(String value) {
            addCriterion("quotation_id <>", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdGreaterThan(String value) {
            addCriterion("quotation_id >", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdGreaterThanOrEqualTo(String value) {
            addCriterion("quotation_id >=", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdLessThan(String value) {
            addCriterion("quotation_id <", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdLessThanOrEqualTo(String value) {
            addCriterion("quotation_id <=", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdLike(String value) {
            addCriterion("quotation_id like", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdNotLike(String value) {
            addCriterion("quotation_id not like", value, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdIn(List<String> values) {
            addCriterion("quotation_id in", values, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdNotIn(List<String> values) {
            addCriterion("quotation_id not in", values, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdBetween(String value1, String value2) {
            addCriterion("quotation_id between", value1, value2, "quotationId");
            return (Criteria) this;
        }

        public Criteria andQuotationIdNotBetween(String value1, String value2) {
            addCriterion("quotation_id not between", value1, value2, "quotationId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositIsNull() {
            addCriterion("received_deposit is null");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositIsNotNull() {
            addCriterion("received_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositEqualTo(Integer value) {
            addCriterion("received_deposit =", value, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositNotEqualTo(Integer value) {
            addCriterion("received_deposit <>", value, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositGreaterThan(Integer value) {
            addCriterion("received_deposit >", value, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositGreaterThanOrEqualTo(Integer value) {
            addCriterion("received_deposit >=", value, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositLessThan(Integer value) {
            addCriterion("received_deposit <", value, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositLessThanOrEqualTo(Integer value) {
            addCriterion("received_deposit <=", value, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositIn(List<Integer> values) {
            addCriterion("received_deposit in", values, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositNotIn(List<Integer> values) {
            addCriterion("received_deposit not in", values, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositBetween(Integer value1, Integer value2) {
            addCriterion("received_deposit between", value1, value2, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andReceivedDepositNotBetween(Integer value1, Integer value2) {
            addCriterion("received_deposit not between", value1, value2, "receivedDeposit");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateIsNull() {
            addCriterion("estimated_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateIsNotNull() {
            addCriterion("estimated_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateEqualTo(Date value) {
            addCriterion("estimated_delivery_date =", value, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateNotEqualTo(Date value) {
            addCriterion("estimated_delivery_date <>", value, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateGreaterThan(Date value) {
            addCriterion("estimated_delivery_date >", value, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("estimated_delivery_date >=", value, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateLessThan(Date value) {
            addCriterion("estimated_delivery_date <", value, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("estimated_delivery_date <=", value, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateIn(List<Date> values) {
            addCriterion("estimated_delivery_date in", values, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateNotIn(List<Date> values) {
            addCriterion("estimated_delivery_date not in", values, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("estimated_delivery_date between", value1, value2, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("estimated_delivery_date not between", value1, value2, "estimatedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateIsNull() {
            addCriterion("actual_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateIsNotNull() {
            addCriterion("actual_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateEqualTo(Date value) {
            addCriterion("actual_delivery_date =", value, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateNotEqualTo(Date value) {
            addCriterion("actual_delivery_date <>", value, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateGreaterThan(Date value) {
            addCriterion("actual_delivery_date >", value, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_delivery_date >=", value, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateLessThan(Date value) {
            addCriterion("actual_delivery_date <", value, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("actual_delivery_date <=", value, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateIn(List<Date> values) {
            addCriterion("actual_delivery_date in", values, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateNotIn(List<Date> values) {
            addCriterion("actual_delivery_date not in", values, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("actual_delivery_date between", value1, value2, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andActualDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("actual_delivery_date not between", value1, value2, "actualDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateIsNull() {
            addCriterion("estimated_arrival_date is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateIsNotNull() {
            addCriterion("estimated_arrival_date is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateEqualTo(Date value) {
            addCriterion("estimated_arrival_date =", value, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateNotEqualTo(Date value) {
            addCriterion("estimated_arrival_date <>", value, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateGreaterThan(Date value) {
            addCriterion("estimated_arrival_date >", value, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("estimated_arrival_date >=", value, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateLessThan(Date value) {
            addCriterion("estimated_arrival_date <", value, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateLessThanOrEqualTo(Date value) {
            addCriterion("estimated_arrival_date <=", value, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateIn(List<Date> values) {
            addCriterion("estimated_arrival_date in", values, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateNotIn(List<Date> values) {
            addCriterion("estimated_arrival_date not in", values, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateBetween(Date value1, Date value2) {
            addCriterion("estimated_arrival_date between", value1, value2, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalDateNotBetween(Date value1, Date value2) {
            addCriterion("estimated_arrival_date not between", value1, value2, "estimatedArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateIsNull() {
            addCriterion("actual_arrival_date is null");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateIsNotNull() {
            addCriterion("actual_arrival_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateEqualTo(Date value) {
            addCriterion("actual_arrival_date =", value, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateNotEqualTo(Date value) {
            addCriterion("actual_arrival_date <>", value, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateGreaterThan(Date value) {
            addCriterion("actual_arrival_date >", value, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_arrival_date >=", value, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateLessThan(Date value) {
            addCriterion("actual_arrival_date <", value, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateLessThanOrEqualTo(Date value) {
            addCriterion("actual_arrival_date <=", value, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateIn(List<Date> values) {
            addCriterion("actual_arrival_date in", values, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateNotIn(List<Date> values) {
            addCriterion("actual_arrival_date not in", values, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateBetween(Date value1, Date value2) {
            addCriterion("actual_arrival_date between", value1, value2, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andActualArrivalDateNotBetween(Date value1, Date value2) {
            addCriterion("actual_arrival_date not between", value1, value2, "actualArrivalDate");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
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

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Long value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Long value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Long value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Long value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Long> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Long> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Long value1, Long value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdIsNull() {
            addCriterion("supplier_group_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdIsNotNull() {
            addCriterion("supplier_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdEqualTo(Long value) {
            addCriterion("supplier_group_id =", value, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdNotEqualTo(Long value) {
            addCriterion("supplier_group_id <>", value, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdGreaterThan(Long value) {
            addCriterion("supplier_group_id >", value, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_group_id >=", value, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdLessThan(Long value) {
            addCriterion("supplier_group_id <", value, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_group_id <=", value, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdIn(List<Long> values) {
            addCriterion("supplier_group_id in", values, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdNotIn(List<Long> values) {
            addCriterion("supplier_group_id not in", values, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdBetween(Long value1, Long value2) {
            addCriterion("supplier_group_id between", value1, value2, "supplierGroupId");
            return (Criteria) this;
        }

        public Criteria andSupplierGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_group_id not between", value1, value2, "supplierGroupId");
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