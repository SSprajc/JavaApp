/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.dal.sql.SqlUserRepository;

/**
 *
 * @author sandr
 */
public class UserRepositoryFactory {

    private UserRepositoryFactory() {
    }
    
    public static UserRepository getRepository() throws Exception {
        return new SqlUserRepository();
    }
    
    
}
