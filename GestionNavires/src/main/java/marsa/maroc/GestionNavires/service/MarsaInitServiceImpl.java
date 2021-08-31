package marsa.maroc.GestionNavires.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marsa.maroc.GestionNavires.dao.GrueRepository;
import marsa.maroc.GestionNavires.entities.Grue;
@Transactional
@Service
public class MarsaInitServiceImpl implements IMarsaInitService{
	@Autowired
	private GrueRepository grueRepository;
	@Override
	public void initGrues() {
		for(int i=1;i<=10;i++) {
			Grue grue = new Grue();
			grue.setName("grue "+i);
			grue.setTravail(false);
			grue.setNavire(null);
			grueRepository.save(grue);
		}
		
	}

}
