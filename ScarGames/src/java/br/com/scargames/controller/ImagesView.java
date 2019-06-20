/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author aluno1
 */
@Named(value = "imagesView")
@SessionScoped
public class ImagesView implements Serializable {

    /**
     * Creates a new instance of ImagesView
     */
    
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 0; i <= 3; i++) {
            images.add("god" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
