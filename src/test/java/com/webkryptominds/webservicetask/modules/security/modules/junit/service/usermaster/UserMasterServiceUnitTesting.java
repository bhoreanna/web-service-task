package com.webkryptominds.webservicetask.modules.security.modules.junit.service.usermaster;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.webkryptominds.webservicetask.modules.security.modules.usermaster.UserMasterRepository;
import com.webkryptominds.webservicetask.modules.security.modules.usermaster.UserMasterService;
@RunWith(MockitoJUnitRunner.class)
public class UserMasterServiceUnitTesting {

	

	@InjectMocks
	private UserMasterService userMasterService;

	@Mock
	private UserMasterRepository userMasterRepository;

	@Test
	public void getAllUserMasterTest() {
//		when(repository.findAll()).thenReturn(
//				Stream.of(new UserMasterService(), new UserMasterService()).collect(Collectors.toList()));
//		assertEquals(2, userMasterService.getUserMasterList().size());
		
		
	}
	
	
	public UserMasterServiceUnitTesting() {
		// TODO Auto-generated constructor stub
	}

}
