package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import daoI.IItemDao;

@Controller 
public class ProjectController {
	@Resource
	private IProjectDao ProjectDao;
}
