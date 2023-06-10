package com.itfactory;

public class ClasaMainPentruOptionala_JobDAO {
    public static void main(String[] args) {
        JobDAO jobDao = new JobDAO();
        Job job = new Job(1234, "Third part", "Management", 1000);
        Job job1 = new Job(1111, "Forth part", "Management", 1000);
        jobDao.deleteJobExample(job1);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+");

        jobDao.insertJobExample(job1);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+");

        jobDao.updateJobDomainExample("Management","IT");
        jobDao.updateJobDomainIndividualExample(1233, "Management");
        jobDao.updateJobDomainIndividualExample(1241, "Management");

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+");
jobDao.selectAllJobExample();


    }

}
