package com.pomoguy.ladyflecs.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetPresentResponse {
    private String url;

    private String name;

    private String additionalWish;



}
