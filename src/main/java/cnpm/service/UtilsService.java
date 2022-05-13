package cnpm.service;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UtilsService {
	@Autowired
	ServletContext context;
	
	public String luuFile(MultipartFile file) {
		if(file.isEmpty()) {
			return null;
		}
		try{
			System.out.println("sys "+System.currentTimeMillis());
			String filePath = context.getRealPath("/resources/file/" + file.getOriginalFilename() );
			file.transferTo(new File(filePath));
			
			System.out.println("file " + filePath);
			
			/*
			 * model.addAttribute("file_name", file.getOriginalFilename());
			 * model.addAttribute("cv_name", cv.getOriginalFilename());
			 * model.addAttribute("cv_type", cv.getContentType());
			 * model.addAttribute("cv_size", cv.getSize());
			 */
			
			Thread.sleep(5000);
			return file.getOriginalFilename();
			
		}
		catch(Exception e){
			System.out.println(e.getCause());
			
		}
		return null;
	}
}
