package com.umi.filiere.groupesection;

import com.umi.filiere.groupesection.controller.groupeSection.GroupController;
import com.umi.filiere.groupesection.controller.groupeSection.ScheduleController;
import com.umi.filiere.groupesection.controller.groupeSection.SectionController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class SectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SectionApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(SectionController sectionController, ScheduleController scheduleController, GroupController groupController) {
        return args -> {
           /* SectionMapper sectionMapper = null;
            // Create and save an example department when the application starts
            SectionResponseDTO sectionResponseDTO = new SectionResponseDTO();
            sectionResponseDTO.setName("Example 1");
            sectionResponseDTO.setDescription("This is an example Section 1.");
            sectionResponseDTO.setSlug("example-Section");
            sectionController.createSection(sectionResponseDTO);

            /*ScheduleResponseDTO scheduleResponseDTO =new ScheduleResponseDTO();
            scheduleResponseDTO.setName("SMA1");
            scheduleResponseDTO.setSchedule("/home/schedule");
            scheduleResponseDTO.setSection(sectionMapper.mapToSection(sectionResponseDTO));
            scheduleController.createSchedule(scheduleResponseDTO);

            GroupResponseDTO groupResponseDTO=new GroupResponseDTO();
            groupResponseDTO.setName("SMA A");
            groupResponseDTO.setDescription("SMA A is a group");
            groupResponseDTO.setSection(sectionMapper.mapToSection(sectionResponseDTO));
            groupController.createGroup(groupResponseDTO);*/
        };
    }
}
