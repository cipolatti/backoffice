package com.unitech.backoffice.dto.user;

import com.unitech.backoffice.model.UserModel;

public record DetailsUserDto(Long id, String name, String login) {
    public DetailsUserDto(UserModel userModel){
        this(userModel.getId(), userModel.getName(), userModel.getLogin());
    }
}
