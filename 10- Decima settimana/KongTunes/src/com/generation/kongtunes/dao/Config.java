package com.generation.kongtunes.dao;

import com.generation.utility.database.Database;

public class Config 
{
	public final static Database DB = new Database("root", "root", "kongtunes");
	public final static DAOTraccia TT = new DAOTraccia();
	public final static DAOAlbum AA = new DAOAlbum();
	public final static DAOFilm FF = new DAOFilm();
	public final static DAOAutore AU = new DAOAutore();
}
