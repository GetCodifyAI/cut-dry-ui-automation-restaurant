package com.cutanddry.qa.data.models;

import lombok.*;

@Data
public class ForgotPasswordUser {
    private String email_valid;
    private String mobile_valid;
    private String email_invalid;
    private String mobile_invalid;
    private String email_unauthorized;
    private String mobile_unauthorized;
    private String email_valid_wl;
    private String mobile_valid_wl;
    private String email_invalid_wl;
    private String mobile_invalid_wl;
    private String email_unauthorized_wl;
    private String mobile_unauthorized_wl;
}
