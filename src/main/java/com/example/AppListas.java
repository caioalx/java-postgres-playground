package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Cliente;

public class AppListas {
    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Caio");
        
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Cintia");    
        
        List<Cliente> listaClientes = new ArrayList<>();
    
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);   

        listaClientes.remove(0);

        
        
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }

    }

}
