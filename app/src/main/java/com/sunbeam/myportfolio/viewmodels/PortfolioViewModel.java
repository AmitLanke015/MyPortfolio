package com.sunbeam.myportfolio.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sunbeam.myportfolio.R;
import com.sunbeam.myportfolio.models.Certificate;
import com.sunbeam.myportfolio.models.Experience;
import com.sunbeam.myportfolio.models.Project;
import com.sunbeam.myportfolio.models.Skill;

import java.util.ArrayList;
import java.util.List;

public class PortfolioViewModel extends ViewModel {

    private MutableLiveData<List<Project>> projects;
    private MutableLiveData<List<Skill>> skills;
    private MutableLiveData<List<Certificate>> certificates;
    private MutableLiveData<List<Experience>> experiences;

    public LiveData<List<Project>> getProjects() {
        if (projects == null) {
            projects = new MutableLiveData<>();
            loadProjects();
        }
        return projects;
    }

    public LiveData<List<Skill>> getSkills() {
        if (skills == null) {
            skills = new MutableLiveData<>();
            loadSkills();
        }
        return skills;
    }

    public LiveData<List<Certificate>> getCertificates() {
        if (certificates == null) {
            certificates = new MutableLiveData<>();
            loadCertificates();
        }
        return certificates;
    }

    public LiveData<List<Experience>> getExperiences() {
        if (experiences == null) {
            experiences = new MutableLiveData<>();
            loadExperiences();
        }
        return experiences;
    }

    private void loadProjects() {
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("Video Streaming Platform", "Netflix-style video streaming platform with subscription management, JWT authentication, watch history, likes, premium content, and payment integration.", "Java, Spring Boot, MySQL, JWT", "https://github.com/AmitLanke015", "https://demo.com", 0));
        projectList.add(new Project("Shopping Cart Application", "Mobile shopping application with product listing, cart management, authentication, and order processing.", "React Native, Node.js, Express.js, MySQL", "https://github.com/AmitLanke015", "https://demo.com", 0));
        projectList.add(new Project("Student Management System", "Manage students, teachers, subjects, authentication, and reporting.", "Java, Spring Boot, SQL", "https://github.com/AmitLanke015", "https://demo.com", 0));
        projects.setValue(projectList);
    }

    private void loadSkills() {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill("Java", 90, R.drawable.ic_java));
        skillList.add(new Skill("SQL", 90, R.drawable.ic_mysql));
        skillList.add(new Skill("Spring Boot", 85, R.drawable.ic_spring));
        skillList.add(new Skill("Android", 85, R.drawable.ic_android));
        skillList.add(new Skill("React", 80, R.drawable.ic_react));
        skillList.add(new Skill("Python", 80, R.drawable.ic_python));
        skillList.add(new Skill("Express.js", 75, R.drawable.ic_express));
        skillList.add(new Skill("Node.js", 75, R.drawable.ic_nodejs));
        skills.setValue(skillList);
    }

    private void loadCertificates() {
        List<Certificate> certList = new ArrayList<>();
        certList.add(new Certificate(
                "Python Programming Certification",
                "SevenMentor & Training Pvt. Ltd., Pune",
                "2021",
                "Completed comprehensive training in Python programming with hands-on experience in core Python, object-oriented programming, file handling, exception handling, modules, and application development fundamentals.",
                "https://drive.google.com/file/d/16OERKPlS-3hzR6tGY6eecNgwjsEPFDEF/view?usp=sharing"
        ));
        certList.add(new Certificate(
                "Front End Web Development Certification",
                "Technical Coding Research Innovation (TCR Innovation), Navi Mumbai",
                "2022",
                "In-depth knowledge of HTML5, CSS3, JavaScript, and modern frontend frameworks.",
                "https://drive.google.com/file/d/1QG5vY7IZe1c1DbGUYB_QgUYd5FBQ4cQS/view?usp=sharing"
        ));
        certList.add(new Certificate(
                "Core Java + SQL Certification",
                "Technical Coding Research Innovation (TCR Innovation), Navi Mumbai",
                "2022",
                "Completed training in Core Java and SQL, covering OOP, JDBC, and database fundamentals.",
                "https://drive.google.com/file/d/1LXASj4_CoSGnrb2QsgnMVH8ER4D5Bwyf/view?usp=sharing"
        ));
        certificates.setValue(certList);
    }

    private void loadExperiences() {
        List<Experience> expList = new ArrayList<>();

        expList.add(new Experience(
                "Python Programming Certification",
                "Completed professional training in Python programming covering core concepts, OOP, and problem-solving.",
                "2021"));

        expList.add(new Experience(
                "Front End Web Development Certification",
                "Completed training in HTML, CSS, JavaScript, and responsive web design.",
                "2022"));

        expList.add(new Experience(
                "Core Java + SQL Certification",
                "Completed training in Core Java, SQL, OOP, JDBC, and database fundamentals.",
                "2022"));

        experiences.setValue(expList);
    }
}
