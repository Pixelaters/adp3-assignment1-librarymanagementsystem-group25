package za.ac.cput.service;

import za.ac.cput.domain.ClientBookId;

import java.util.Set;

public interface ClientBookIdService extends IService <ClientBookId , String> {

    Set<ClientBookId> getAll();
}
