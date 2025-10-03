package br.edu.infnet.webapi.model.loader;

import br.edu.infnet.webapi.client.OpenCepFeignClient;
import br.edu.infnet.webapi.model.domain.Seller;
import br.edu.infnet.webapi.model.repository.SellerRepository;
import br.edu.infnet.webapi.model.service.AddressService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(value = 1)
public class SellerLoader implements ApplicationRunner {

    private AddressService addressService;
    private SellerRepository sellerRepository;
    private OpenCepFeignClient openCepFeignClient;

    SellerLoader(AddressService addressService,  SellerRepository sellerRepository,  OpenCepFeignClient openCepFeignClient) {
        this.addressService = addressService;
        this.sellerRepository = sellerRepository;
        this.openCepFeignClient = openCepFeignClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader fileReader = new FileReader("sellers.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] fields = null;
        String line = bufferedReader.readLine();

        while (line  != null) {

            Seller seller = new Seller();
            fields = line.split(";");
            seller.setName(fields[0]);
            seller.setEmail(fields[1]);
            seller.setActive(Boolean.parseBoolean(fields[2]));
            seller.setAddress(addressService.getSellerAddress(fields[8],fields[10],Integer.valueOf(fields[4])));
            seller.setCnpj(fields[11]);
            OpenCepFeignClient.OpenCepAddressResponse response = openCepFeignClient.getAddress(fields[8].replace("-","").trim());
            System.out.println(response.getEstado());
            sellerRepository.save(seller);

            line = bufferedReader.readLine();

        }



    }
}
