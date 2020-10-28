package cv3000.services;

import java.util.Collection;

import cv3000.models.CurriculumVitae;

public interface ICurriculumVitaeDAO {
	
	Collection<CurriculumVitae> findAllCurriculumVitae();

}