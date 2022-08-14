package za.ac.cput.service.impl;

import za.ac.cput.domain.ClientAddress;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.service.IService;

import java.util.List;

public interface ClientContactIService extends IService<ClientContact,String> {

    public List<ClientContact> getAll();
}
