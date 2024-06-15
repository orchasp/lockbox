package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Bank;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.repository.BankRepository;
import com.orchasp.app.induslockbox.repository.CompanyRepository;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;
    
    @Autowired
    private CompanyRepository companyRepository;

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public Optional<Bank> findById(Long id) {
        return bankRepository.findById(id);
    }
    
    public Bank updateBank(Long id, Bank updatedBank) {
        Optional<Bank> existingBankOpt = bankRepository.findById(id);
        if (existingBankOpt.isPresent()) {
            Bank existingBank = existingBankOpt.get();

            // Update basic fields
            existingBank.setAccountHolderName(updatedBank.getAccountHolderName());
            existingBank.setBankAccountNumber(updatedBank.getBankAccountNumber());
            existingBank.setIfccode(updatedBank.getIfccode());
            existingBank.setBankName(updatedBank.getBankName());
            existingBank.setBranch(updatedBank.getBranch());
            existingBank.setIrccode(updatedBank.getIrccode());
            existingBank.setMrccode(updatedBank.getMrccode());
            existingBank.setRbicode(updatedBank.getRbicode());
            existingBank.setTransactionCode(updatedBank.getTransactionCode());
            existingBank.setAccountType(updatedBank.getAccountType());
            existingBank.setPassword(updatedBank.getPassword());

            // Update or save company
            Company updatedCompany = updatedBank.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingBank.getCompany();
                if (existingCompany != null) {
                	 existingCompany.setOrganizationCode(updatedCompany.getOrganizationCode());
                     existingCompany.setCompanyname(updatedCompany.getCompanyname());
                     existingCompany.setInceptionDate(updatedCompany.getInceptionDate());
                     existingCompany.setRegisterNo(updatedCompany.getRegisterNo());
                     existingCompany.setPhoneNo(updatedCompany.getPhoneNo());
                     existingCompany.setEmail(updatedCompany.getEmail());
                     existingCompany.setFlatNo(updatedCompany.getFlatNo());
                     existingCompany.setWebsite(updatedCompany.getWebsite());
                     existingCompany.setCity(updatedCompany.getCity());
                     existingCompany.setState(updatedCompany.getState());
                     existingCompany.setPincode(updatedCompany.getPincode());
                    companyRepository.save(existingCompany);
                } else {
                    companyRepository.save(updatedCompany);
                    existingBank.setCompany(updatedCompany);
                }
            }

            return bankRepository.save(existingBank);
        } else {
            throw new RuntimeException("Bank not found with id " + id);
        }
    }

    public Bank save(Bank bank) {
//    	if (bank.getIFCcode() == null || bank.getIFCcode().isEmpty()) {
//            throw new IllegalArgumentException("IFCcode must not be null or empty");
//        }
        return bankRepository.save(bank);
    }

    public void deleteById(Long id) {
        bankRepository.deleteById(id);
    }
}