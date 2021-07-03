package com.zealot.dcasting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectDetailsExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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

        public Criteria andDetailProgressIsNull() {
            addCriterion("detail_progress is null");
            return (Criteria) this;
        }

        public Criteria andDetailProgressIsNotNull() {
            addCriterion("detail_progress is not null");
            return (Criteria) this;
        }

        public Criteria andDetailProgressEqualTo(String value) {
            addCriterion("detail_progress =", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressNotEqualTo(String value) {
            addCriterion("detail_progress <>", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressGreaterThan(String value) {
            addCriterion("detail_progress >", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_progress >=", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressLessThan(String value) {
            addCriterion("detail_progress <", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressLessThanOrEqualTo(String value) {
            addCriterion("detail_progress <=", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressLike(String value) {
            addCriterion("detail_progress like", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressNotLike(String value) {
            addCriterion("detail_progress not like", value, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressIn(List<String> values) {
            addCriterion("detail_progress in", values, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressNotIn(List<String> values) {
            addCriterion("detail_progress not in", values, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressBetween(String value1, String value2) {
            addCriterion("detail_progress between", value1, value2, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailProgressNotBetween(String value1, String value2) {
            addCriterion("detail_progress not between", value1, value2, "detailProgress");
            return (Criteria) this;
        }

        public Criteria andDetailNumberIsNull() {
            addCriterion("detail_number is null");
            return (Criteria) this;
        }

        public Criteria andDetailNumberIsNotNull() {
            addCriterion("detail_number is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNumberEqualTo(String value) {
            addCriterion("detail_number =", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberNotEqualTo(String value) {
            addCriterion("detail_number <>", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberGreaterThan(String value) {
            addCriterion("detail_number >", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberGreaterThanOrEqualTo(String value) {
            addCriterion("detail_number >=", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberLessThan(String value) {
            addCriterion("detail_number <", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberLessThanOrEqualTo(String value) {
            addCriterion("detail_number <=", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberLike(String value) {
            addCriterion("detail_number like", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberNotLike(String value) {
            addCriterion("detail_number not like", value, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberIn(List<String> values) {
            addCriterion("detail_number in", values, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberNotIn(List<String> values) {
            addCriterion("detail_number not in", values, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberBetween(String value1, String value2) {
            addCriterion("detail_number between", value1, value2, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailNumberNotBetween(String value1, String value2) {
            addCriterion("detail_number not between", value1, value2, "detailNumber");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryIsNull() {
            addCriterion("detail_category is null");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryIsNotNull() {
            addCriterion("detail_category is not null");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryEqualTo(String value) {
            addCriterion("detail_category =", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryNotEqualTo(String value) {
            addCriterion("detail_category <>", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryGreaterThan(String value) {
            addCriterion("detail_category >", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("detail_category >=", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryLessThan(String value) {
            addCriterion("detail_category <", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryLessThanOrEqualTo(String value) {
            addCriterion("detail_category <=", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryLike(String value) {
            addCriterion("detail_category like", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryNotLike(String value) {
            addCriterion("detail_category not like", value, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryIn(List<String> values) {
            addCriterion("detail_category in", values, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryNotIn(List<String> values) {
            addCriterion("detail_category not in", values, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryBetween(String value1, String value2) {
            addCriterion("detail_category between", value1, value2, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCategoryNotBetween(String value1, String value2) {
            addCriterion("detail_category not between", value1, value2, "detailCategory");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionIsNull() {
            addCriterion("detail_caption is null");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionIsNotNull() {
            addCriterion("detail_caption is not null");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionEqualTo(String value) {
            addCriterion("detail_caption =", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionNotEqualTo(String value) {
            addCriterion("detail_caption <>", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionGreaterThan(String value) {
            addCriterion("detail_caption >", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionGreaterThanOrEqualTo(String value) {
            addCriterion("detail_caption >=", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionLessThan(String value) {
            addCriterion("detail_caption <", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionLessThanOrEqualTo(String value) {
            addCriterion("detail_caption <=", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionLike(String value) {
            addCriterion("detail_caption like", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionNotLike(String value) {
            addCriterion("detail_caption not like", value, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionIn(List<String> values) {
            addCriterion("detail_caption in", values, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionNotIn(List<String> values) {
            addCriterion("detail_caption not in", values, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionBetween(String value1, String value2) {
            addCriterion("detail_caption between", value1, value2, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailCaptionNotBetween(String value1, String value2) {
            addCriterion("detail_caption not between", value1, value2, "detailCaption");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionIsNull() {
            addCriterion("detail_description is null");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionIsNotNull() {
            addCriterion("detail_description is not null");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionEqualTo(String value) {
            addCriterion("detail_description =", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotEqualTo(String value) {
            addCriterion("detail_description <>", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionGreaterThan(String value) {
            addCriterion("detail_description >", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("detail_description >=", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLessThan(String value) {
            addCriterion("detail_description <", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLessThanOrEqualTo(String value) {
            addCriterion("detail_description <=", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLike(String value) {
            addCriterion("detail_description like", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotLike(String value) {
            addCriterion("detail_description not like", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionIn(List<String> values) {
            addCriterion("detail_description in", values, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotIn(List<String> values) {
            addCriterion("detail_description not in", values, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionBetween(String value1, String value2) {
            addCriterion("detail_description between", value1, value2, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotBetween(String value1, String value2) {
            addCriterion("detail_description not between", value1, value2, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdIsNull() {
            addCriterion("detail_supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdIsNotNull() {
            addCriterion("detail_supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdEqualTo(Long value) {
            addCriterion("detail_supplier_id =", value, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdNotEqualTo(Long value) {
            addCriterion("detail_supplier_id <>", value, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdGreaterThan(Long value) {
            addCriterion("detail_supplier_id >", value, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_supplier_id >=", value, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdLessThan(Long value) {
            addCriterion("detail_supplier_id <", value, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("detail_supplier_id <=", value, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdIn(List<Long> values) {
            addCriterion("detail_supplier_id in", values, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdNotIn(List<Long> values) {
            addCriterion("detail_supplier_id not in", values, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdBetween(Long value1, Long value2) {
            addCriterion("detail_supplier_id between", value1, value2, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("detail_supplier_id not between", value1, value2, "detailSupplierId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdIsNull() {
            addCriterion("detail_supplier_group_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdIsNotNull() {
            addCriterion("detail_supplier_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdEqualTo(Long value) {
            addCriterion("detail_supplier_group_id =", value, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdNotEqualTo(Long value) {
            addCriterion("detail_supplier_group_id <>", value, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdGreaterThan(Long value) {
            addCriterion("detail_supplier_group_id >", value, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_supplier_group_id >=", value, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdLessThan(Long value) {
            addCriterion("detail_supplier_group_id <", value, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("detail_supplier_group_id <=", value, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdIn(List<Long> values) {
            addCriterion("detail_supplier_group_id in", values, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdNotIn(List<Long> values) {
            addCriterion("detail_supplier_group_id not in", values, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdBetween(Long value1, Long value2) {
            addCriterion("detail_supplier_group_id between", value1, value2, "detailSupplierGroupId");
            return (Criteria) this;
        }

        public Criteria andDetailSupplierGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("detail_supplier_group_id not between", value1, value2, "detailSupplierGroupId");
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