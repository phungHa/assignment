# assignment
**back-end Spring Framwork**  
**API that allow users to upload "gpx" file and store mandatory information such as "metadata, waypoint, track":** \
URL: http://localhost:8080/api/upload  \
Method: POST \
Body : Form Data { file : gpx file}

**API endpoint to return a list of "Latest track" :**
http://localhost:8080/api/lastest?pageIndex=0&numItem=1  \
Method: GET  \
params :     
      pageIndex : integer, page number start is 0,default is 0.  
      numItem : integer, number of item in a page , default 10 item per page.  

**API endpoint to allow users to view details of their gpx file:**. 
when user click a item in list of lastest track, get user to detail view page :  
- name , description of track get from previous page ( lastest track view page).  
- call API get all track point of that track by track ID:  
  http://localhost:8080/api/waypoint?trackId=1  
  method: GET 
  params:  
        trackId : id of track that user clicked.
        
When user stick in box "show way points". 
- call API get all way point of that track by track ID:  
  http://localhost:8080/api/trackpoint?trackId=1. 
  method: GET 
  params:  
        trackId : id of track that user clicked.  
        
When user click download, call API to get download link ( it could be a AWS S3 link, using to store file).  
 
**I think user want to some useful info like : average speed, max speed, start time, end time, max elevation, total time on that trip, ...Then we will add them to view detail page or another page.**
