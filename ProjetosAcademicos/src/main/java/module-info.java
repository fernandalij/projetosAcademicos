module ProjetosAcademicos {
	exports com.projetosAcademicos.domain.dto;
	exports com.projetosAcademicos.api;
	exports com.projetosAcademicos;
	exports com.projetosAcademicos.domain;

	requires com.sun.istack.runtime;
	requires java.persistence;
	requires lombok;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
}