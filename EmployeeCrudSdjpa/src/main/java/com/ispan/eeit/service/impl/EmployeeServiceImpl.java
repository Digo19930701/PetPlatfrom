package com.ispan.eeit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit.dao.EmployeeRepository;
import com.ispan.eeit.dao.EmployeeRepositoryCustom;
import com.ispan.eeit.model.Employee;
import com.ispan.eeit.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeDao;
	
	EmployeeRepositoryCustom employeeRepositoryCustom;
	
//	@Autowired
	EmployeeServiceImpl(EmployeeRepository employeeDao, EmployeeRepositoryCustom employeeRepositoryCustom) {
		super();
		this.employeeDao = employeeDao;
		this.employeeRepositoryCustom = employeeRepositoryCustom;
	}

	@Override
	public void resetEmployeeTable() {
		throw new RuntimeException("本系統未提供此功能");
	}


	@Override
	public void save(Employee employee) {
		
		employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
//		employeeDao.update(employee);
		employeeDao.save(employee);
	}

	@Override
	public Employee findByEmployeeId(String employeeId) {
		Employee emp = employeeDao.findByEmployeeId(employeeId);
		return emp;
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		employeeDao.deleteById(id);
	}

	@Override
	public boolean existsByEmployeeId(Employee employee) {
		if (employeeRepositoryCustom.isPersist(employee)) {
			employeeRepositoryCustom.detach(employee);
		}
//		if (employeeDao.existsById(employee.getId())) {
//		}
		Employee emp = findByEmployeeId( employee.getEmployeeId() );
		return  emp != null;
	}

	@Override
	public boolean isPersist(Employee employee) {
		boolean ans = employeeDao.existsById(employee.getId());
		return ans;
	}

	@Override
	public void detach(Employee employee) {
		employeeRepositoryCustom.detach(employee);
	}

}
