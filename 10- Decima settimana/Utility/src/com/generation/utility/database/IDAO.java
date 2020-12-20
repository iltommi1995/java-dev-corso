package com.generation.utility.database;

import java.util.List;

import com.generation.utility.entities.Entity;

/**
 * Questa interfaccia sarà imlementata in tutti i dao che
 * faremo nelle nostre applicazioni, così saremo costretti a 
 * scrivere tutti i metodi CRUD
 */


public interface IDAO 
{
	public List<Entity> read(String query, String... params);
	public boolean create(Entity e);
	public boolean update(Entity e);
	public boolean delete(int id);
}
