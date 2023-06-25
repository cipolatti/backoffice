package com.unitech.backoffice.dto.user;

import com.unitech.backoffice.model.User;

public record DetailsUserDto(Long id, String name, String login) {
    public DetailsUserDto(User user){
        this(user.getId(), user.getName(), user.getLogin());
    }
}
