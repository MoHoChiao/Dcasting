package com.zealot.dcasting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleOrderDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleOrderDetailsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andItemNumberIsNull() {
            addCriterion("item_number is null");
            return (Criteria) this;
        }

        public Criteria andItemNumberIsNotNull() {
            addCriterion("item_number is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumberEqualTo(String value) {
            addCriterion("item_number =", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotEqualTo(String value) {
            addCriterion("item_number <>", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThan(String value) {
            addCriterion("item_number >", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThanOrEqualTo(String value) {
            addCriterion("item_number >=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThan(String value) {
            addCriterion("item_number <", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThanOrEqualTo(String value) {
            addCriterion("item_number <=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLike(String value) {
            addCriterion("item_number like", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotLike(String value) {
            addCriterion("item_number not like", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberIn(List<String> values) {
            addCriterion("item_number in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotIn(List<String> values) {
            addCriterion("item_number not in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberBetween(String value1, String value2) {
            addCriterion("item_number between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotBetween(String value1, String value2) {
            addCriterion("item_number not between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIsNull() {
            addCriterion("item_category is null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIsNotNull() {
            addCriterion("item_category is not null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryEqualTo(String value) {
            addCriterion("item_category =", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotEqualTo(String value) {
            addCriterion("item_category <>", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryGreaterThan(String value) {
            addCriterion("item_category >", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("item_category >=", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryLessThan(String value) {
            addCriterion("item_category <", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryLessThanOrEqualTo(String value) {
            addCriterion("item_category <=", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryLike(String value) {
            addCriterion("item_category like", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotLike(String value) {
            addCriterion("item_category not like", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIn(List<String> values) {
            addCriterion("item_category in", values, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotIn(List<String> values) {
            addCriterion("item_category not in", values, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryBetween(String value1, String value2) {
            addCriterion("item_category between", value1, value2, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotBetween(String value1, String value2) {
            addCriterion("item_category not between", value1, value2, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCaptionIsNull() {
            addCriterion("item_caption is null");
            return (Criteria) this;
        }

        public Criteria andItemCaptionIsNotNull() {
            addCriterion("item_caption is not null");
            return (Criteria) this;
        }

        public Criteria andItemCaptionEqualTo(String value) {
            addCriterion("item_caption =", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionNotEqualTo(String value) {
            addCriterion("item_caption <>", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionGreaterThan(String value) {
            addCriterion("item_caption >", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionGreaterThanOrEqualTo(String value) {
            addCriterion("item_caption >=", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionLessThan(String value) {
            addCriterion("item_caption <", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionLessThanOrEqualTo(String value) {
            addCriterion("item_caption <=", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionLike(String value) {
            addCriterion("item_caption like", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionNotLike(String value) {
            addCriterion("item_caption not like", value, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionIn(List<String> values) {
            addCriterion("item_caption in", values, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionNotIn(List<String> values) {
            addCriterion("item_caption not in", values, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionBetween(String value1, String value2) {
            addCriterion("item_caption between", value1, value2, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andItemCaptionNotBetween(String value1, String value2) {
            addCriterion("item_caption not between", value1, value2, "itemCaption");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Integer value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Integer value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Integer value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Integer value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Integer> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Integer> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andItemQuantityIsNull() {
            addCriterion("item_quantity is null");
            return (Criteria) this;
        }

        public Criteria andItemQuantityIsNotNull() {
            addCriterion("item_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andItemQuantityEqualTo(Integer value) {
            addCriterion("item_quantity =", value, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityNotEqualTo(Integer value) {
            addCriterion("item_quantity <>", value, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityGreaterThan(Integer value) {
            addCriterion("item_quantity >", value, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_quantity >=", value, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityLessThan(Integer value) {
            addCriterion("item_quantity <", value, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("item_quantity <=", value, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityIn(List<Integer> values) {
            addCriterion("item_quantity in", values, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityNotIn(List<Integer> values) {
            addCriterion("item_quantity not in", values, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityBetween(Integer value1, Integer value2) {
            addCriterion("item_quantity between", value1, value2, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("item_quantity not between", value1, value2, "itemQuantity");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalIsNull() {
            addCriterion("item_subtotal is null");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalIsNotNull() {
            addCriterion("item_subtotal is not null");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalEqualTo(Integer value) {
            addCriterion("item_subtotal =", value, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalNotEqualTo(Integer value) {
            addCriterion("item_subtotal <>", value, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalGreaterThan(Integer value) {
            addCriterion("item_subtotal >", value, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_subtotal >=", value, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalLessThan(Integer value) {
            addCriterion("item_subtotal <", value, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalLessThanOrEqualTo(Integer value) {
            addCriterion("item_subtotal <=", value, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalIn(List<Integer> values) {
            addCriterion("item_subtotal in", values, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalNotIn(List<Integer> values) {
            addCriterion("item_subtotal not in", values, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalBetween(Integer value1, Integer value2) {
            addCriterion("item_subtotal between", value1, value2, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSubtotalNotBetween(Integer value1, Integer value2) {
            addCriterion("item_subtotal not between", value1, value2, "itemSubtotal");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdIsNull() {
            addCriterion("item_supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdIsNotNull() {
            addCriterion("item_supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdEqualTo(Long value) {
            addCriterion("item_supplier_id =", value, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdNotEqualTo(Long value) {
            addCriterion("item_supplier_id <>", value, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdGreaterThan(Long value) {
            addCriterion("item_supplier_id >", value, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_supplier_id >=", value, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdLessThan(Long value) {
            addCriterion("item_supplier_id <", value, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("item_supplier_id <=", value, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdIn(List<Long> values) {
            addCriterion("item_supplier_id in", values, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdNotIn(List<Long> values) {
            addCriterion("item_supplier_id not in", values, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdBetween(Long value1, Long value2) {
            addCriterion("item_supplier_id between", value1, value2, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("item_supplier_id not between", value1, value2, "itemSupplierId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdIsNull() {
            addCriterion("item_supplier_group_id is null");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdIsNotNull() {
            addCriterion("item_supplier_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdEqualTo(Long value) {
            addCriterion("item_supplier_group_id =", value, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdNotEqualTo(Long value) {
            addCriterion("item_supplier_group_id <>", value, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdGreaterThan(Long value) {
            addCriterion("item_supplier_group_id >", value, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_supplier_group_id >=", value, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdLessThan(Long value) {
            addCriterion("item_supplier_group_id <", value, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("item_supplier_group_id <=", value, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdIn(List<Long> values) {
            addCriterion("item_supplier_group_id in", values, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdNotIn(List<Long> values) {
            addCriterion("item_supplier_group_id not in", values, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdBetween(Long value1, Long value2) {
            addCriterion("item_supplier_group_id between", value1, value2, "itemSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andItemSupplierGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("item_supplier_group_id not between", value1, value2, "itemSupplierGroupId");
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