
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<Endereco>();
        String CEP = "";
        buscaCEP buscaCEP = new buscaCEP();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (!CEP.equalsIgnoreCase("sair")) {
            System.out.println("Insira um CEP para pesquisar: ");
            CEP = input.nextLine();

            if  (CEP.equalsIgnoreCase("sair")) {
                break;
            }

            Endereco endereco = buscaCEP.buscaEndereco(CEP);
            enderecos.add(endereco);
        }

        System.out.println(enderecos);

        FileWriter escritor = new FileWriter("enderecos.json");
        escritor.write(gson.toJson(enderecos));
        escritor.close();
    }
}
