package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
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

	public List<Bank> findByCompany_id(Long company_id) {
		return bankRepository.findByCompany_id(company_id);
	}

	public Optional<Bank> findById(Long id) {
		return bankRepository.findById(id);
	}

	public Bank updateBank(Long id, Bank updatedBank, String updatedBy) {
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

			existingBank.setCreatedBy(updatedBank.getCreatedBy());
			existingBank.setCreatedDate(updatedBank.getCreatedDate());
			existingBank.setUpdatedBy(updatedBy);
			existingBank.setUpdatedDate(LocalDateTime.now());
			existingBank.setActive(updatedBank.isActive());
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
					existingCompany.setActive(updatedCompany.isActive());
					existingCompany.setCreatedBy(updatedCompany.getCreatedBy());
					existingCompany.setCreatedDate(updatedCompany.getCreatedDate());
					existingCompany.setUpdatedBy(updatedBy);
					existingCompany.setUpdatedDate(LocalDateTime.now());
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

	public Bank save(Bank bank, String createdBy) {
		Long companyId = bank.getCompany().getCompanyid();
        Optional<Company> company = companyRepository.findById(companyId);
        Company c=company.get();
        bank.setCompany(c);
		bank.setCreatedBy(createdBy);
		bank.setCreatedDate(LocalDateTime.now());
		
		bank.setUpdatedBy(createdBy);
		bank.setUpdatedDate(LocalDateTime.now());
		return bankRepository.save(bank);
	}

	public void deleteById(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);
		if (bankOpt.isPresent()) {
			Bank b = bankOpt.get();
			b.setActive(false);
			bankRepository.save(b);
		}
//        bankRepository.deleteById(id);
	}

	public void activateById(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);
		if (bankOpt.isPresent()) {
			Bank bank = bankOpt.get();
			bank.setActive(true);
			bankRepository.save(bank);
		}
	}
}