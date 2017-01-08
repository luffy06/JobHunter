url: index
req: null
res: null
session: null
nexturl: jsp
comment: null

url: getlogin
req: null
res: null
session: null
nexturl: jsp
comment: null

url: getregister
req: null
res: null
session: null
nexturl: jsp
comment: null

url: reigister
req: {
  username,
  password,
  sex,
  telnumber,
  email,
  wechat,
  workingtime,
  portrait
}
res: null
session: null
nexturl: getlogin
comment: null

url: login
req: {
  username,
  password
}
res: null
session: {
  userid  
}
nexturl: jobinfo
comment: null

url: logout
req: null
res: null
session: clear
nexturl: index
comment: null

url: joblist
req: {
  jobname,
}
res: {
  joblist: [Job],
  jobtypelist: [String],
  jobcount,
  skilllist: [skillid, skillname]
}
session: null
nexturl: jsp
comment: jobname匹配jobname和skillname

url: jobinfo
req: {
  jobid
}
res: {
  job,
  company,
  hr
}
session: null
nexturl: jsp
comment: null

url: favorite
req: {
  favorite: [Favorite],
  action,
}
res: null
session: null
nexturl: nul
comment: ajax

url: postresume
req: {
  jobid
}
res: null
session: null
nexturl: null
comment: ajax

url: companylist
req: {
  companyname
}
res: {
  companylist: [Company],
  jobcount,
  joblist: [Job],

}
session: null
nexturl: jsp
comment: null

url: companyinfo
req: {
  companyid
}
res: {
  company: [Company],
  skillname,
  skillcount,
  joblist
}
session: null
nexturl: jsp
comment: null

url: oxer
req: {
  
}
res: {
  userlist,
  statuslist,
  purposecount,
  purposelist,
  worklist,
}
session: null
nexturl: jsp
comment: null

url: oxerinfo
req: {
  userid
}
res: {
  user: [User],
  resume: [Resume],
  eduexp: [EducationExperience],
  workpp: [WorkPurpose],
  workep: [WorkExperience],
  proexp: [ProjectExperience],
}
session: null
nexturl: jsp
comment: null

url: usercenter
req: null
res: {
  postlist: [Job],
  offerlist: [Job]
}
session: null
nexturl: jsp
comment: user

url: resumeinfo
req: null
res: {
  resume: [Resume],
  eduexp: [EducationExperience],
  workpp: [WorkPurpose],
  workep: [WorkExperience],
  proexp: [ProjectExperience],
}
session: null
nexturl: jsp
comment: null

url: savereusme
req: {
  resume: [Resume],
  eduexp: [EducationExperience],
  workpp: [WorkPurpose],
  workep: [WorkExperience],
  proexp: [ProjectExperience],
}
res: null
session: null
nexturl: resumeinfo
comment: null

url: favoritelist
req: null
res: {
  favoritelist: [Favorite]
}
session: null
nexturl: jsp
comment: null

url: userinfo
req: null
res: {
  user: [User]
}
session: null
nexturl: jsp
comment: null

url: saveuserinfo
req: {
  user: [User]
}
res: null
session: null
nexturl: userinfo
comment: null
