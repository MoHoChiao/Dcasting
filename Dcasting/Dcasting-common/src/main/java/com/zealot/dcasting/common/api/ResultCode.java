package com.zealot.dcasting.common.api;

/**
 * 枚舉一些常用API操作碼
 * Created by LeoLiu on 2020/6/4.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "api.response.code.success"),
    FAILED(500, "api.response.code.fail"),
    VALIDATE_FAILED(404, "ApiResponseCode.User.ParamError"),
    UNAUTHORIZED(401, "ApiResponseCode.User.TokenError"),
    USER_LOCKED(4003, "ApiResponseCode.User.AccountLocked"),
    FORBIDDEN(403, "ApiResponseCode.User.AccessDenied"),
    ACCOUNT_EXIST(600, "ApiResponseCode.User.AccountExist"),
	ACCOUNT_NOT_EXIST(601, "ApiResponseCode.User.AccountNotExist"),
	OLD_PASSWORD_FAILED(602, "ApiResponseCode.User.OldPasswordFail"),
	DELETE_PERMISSION_FIRST(603, "ApiResponseCode.Permission.DeletePermissionFirst"),
	ID_EMPTY(604, "ApiResponseCode.User.IdEmpty"),
	ACCOUNT_OR_EMAIL_NOT_EXIST(605, "ApiResponseCode.User.AccountOrEmailNotExist"),
	ID_LENGTH_FAIL(606, "ApiResponseCode.IdLengthFail"),
	STATUS_FAIL(607, "ApiResponseCode.StatusFail"),
	Q_TO_I_STATUS_FAIL(608, "ApiResponseCode.Quotations.QToIStatusFail"),
	D_TO_Q_STATUS_FAIL(609, "ApiResponseCode.QuotationDetails.DToQStatusFail"),
	D_TO_O_STATUS_FAIL(609, "ApiResponseCode.OrderDetails.DToOStatusFail"),
	FILE_UPLOAD_IO_FAIL(611, "ApiResponseCode.Inquiries.FileUploadIOFail"),
	INQUIRIES_NOT_EXIST(612, "ApiResponseCode.Inquiries.NotExist"),
	QUOTATIONS_NOT_EXIST(613, "ApiResponseCode.Quotations.NotExist"),
	QUOTATIONDETAILS_NOT_EXIST(614, "ApiResponseCode.QuotationDetails.NotExist"),
	ORDERDETAILS_NOT_EXIST(616, "ApiResponseCode.OrderDetails.NotExist"),
	PROJECTS_NOT_EXIST(617, "ApiResponseCode.Projects.NotExist"),
	PROJECTDETAILS_NOT_EXIST(618, "ApiResponseCode.ProjectDetails.NotExist"),
	FILE_NOT_FOUND(619, "ApiResponseCode.Inquiries.FileNotFound"),
	USER_INQUIRIES_PROCESSING(621, "ApiResponseCode.User.InquiriesProcessing"),
	USER_QUOTATIONS_PROCESSING(622, "ApiResponseCode.User.QuotationsProcessing"),
	USER_ORDERS_PROCESSING(623, "ApiResponseCode.User.OrdersProcessing"),
	USER_PROJECTS_PROCESSING(624, "ApiResponseCode.User.ProjectsProcessing"),
	GROUP_INQUIRIES_PROCESSING(625, "ApiResponseCode.Group.InquiriesProcessing"),
	GROUP_QUOTATIONS_PROCESSING(626, "ApiResponseCode.Group.QuotationsProcessing"),
	GROUP_ORDERS_PROCESSING(627, "ApiResponseCode.Group.OrdersProcessing"),
	GROUP_PROJECTS_PROCESSING(628, "ApiResponseCode.Group.ProjectsProcessing"),
	NO_DETAILS_UNDER_QUOTATION(629, "ApiResponseCode.Quotations.NoDetailsUnderQuotation");
	
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
