package com.app.Quize.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Quize.model.Quize;

public interface QuizeDao extends JpaRepository< Quize,Integer>{

}
