/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author sandr
 */
public interface PersonManagable {

    boolean addPerson(Person person);

    boolean updatePerson(Person person);
}
