use jobhunter;

create table dictionary(
  dictitemid int(5),
  dicttypeid int(5),
  name varchar(255),
  description text(65535),
  primary key(dictitemid)
);

create table user(
  userid int(5) auto_increment,
  username varchar(255),
  password varchar(255),
  sex boolean,
  wechat varchar(255),
  email varchar(255),
  telnumber varchar(255),
  portrait varchar(255),
  workingtime varchar(255),
  primary key(userid)
);

create table admin(
  adminid int(5) auto_increment,
  password varchar(255),
  primary key(adminid)
);

create table company(
  companyid int(5),
  fullname varchar(255),
  shortname varchar(255),
  teamintro text(65535),
  industryid int(5),
  scaleid int(5),
  finanacestageid int(5),
  homepage varchar(255),
  logo varchar(255),
  primary key(companyid)
);

create table resume(
  resumeid int(5),
  realname varchar(255),
  birthday datetime,
  advantage text(65535),
  homepage varchar(255),
  statusid int(5),
  ishide boolean,
  primary key(resumeid)
);

create table educationexperience(
  educationexperienceid int(5) auto_increment,
  resumeid int(5),
  starttime datetime,
  endtime datetime,
  schoolid int(5),
  major varchar(255),
  diplomaid varchar(255),
  description text(65535),
  primary key(educationexperienceid),
  foreign key(resumeid) references resume(resumeid)
);

create table workpurpose(
  workpurposeid int(5) auto_increment,
  resumeid int(5),
  jobtypeid int(5),
  industryid int(5),
  cityid int(5),
  salaryid int(5),
  primary key(workpurposeid),
  foreign key(resumeid) references resume(resumeid)
);

create table workexperience(
  workexperienceid int(5) auto_increment,
  resumeid int(5),
  starttime datetime,
  endtime datetime,
  companyid int(5),
  jobtypeid int(5),
  jobname varchar(255),
  skillid int(5),
  primary key(workexperienceid),
  foreign key(resumeid) references resume(resumeid)
);

create table projectexperience(
  projectexperienceid int(5) auto_increment,
  resumeid int(5),
  starttime datetime,
  endtime datetime,
  projectname varchar(255),
  description text(65535),
  url varchar(255),
  achievement varchar(255),
  primary key(projectexperienceid),
  foreign key(resumeid) references resume(resumeid)
);

create table job(
  jobid int(5) auto_increment,
  userid int(5),
  jobtypeid int(5),
  jobname varchar(255),
  skillid int(5),
  salaryid int(5),
  experienceid int(5),
  diplomaid int(5),
  cityid int(5),
  workaddress varchar(255),
  description text(65535),
  isclosed boolean,
  primary key(jobid),
  foreign key(userid) references user(userid)
);

create table jobstatistics(
  jobid int(5),
  browsecount int(5),
  zancount int(5),
  primary key(jobid),
  foreign key(jobid) references job(jobid)
);

create table applydetail(
  applyid int(5) auto_increment,
  jobid int(5),
  resumeid int(5),
  createtime datetime,
  primary key(applyid),
  foreign key(jobid) references job(jobid),
  foreign key(resumeid) references resume(resumeid)
);

create table favorite(
  favoriteid int(5),
  type int(5),
  userid int(5),
  createtime datetime,
  primary key(favoriteid, type)
);