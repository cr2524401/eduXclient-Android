
登陆
====

http://211.68.39.82/public_api/api-auth/login/

::

    GET /public_api/api-auth/login/ HTTP/1.1
    Host: 211.68.39.82
    User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
    Accept-Language: zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3
    Accept-Encoding: gzip, deflate
    Cookie: csrftoken=UVJZ87XZYIC88JWdVAs6Dtlnt55pexFJ; sessionid=518201660eb430fd9eeff9723c29dbb1
    Connection: keep-alive
    Cache-Control: max-age=0
    
    HTTP/1.1 200 OK
    Server: nginx/1.1.19
    Date: Wed, 30 Jul 2014 06:56:40 GMT
    Content-Type: text/html; charset=utf-8
    Transfer-Encoding: chunked
    Connection: keep-alive
    Vary: Accept-Encoding, Cookie, Accept-Language
    Content-Language: zh-cn
    Expires: Wed, 30 Jul 2014 06:56:40 GMT
    Last-Modified: Wed, 30 Jul 2014 06:56:40 GMT
    Cache-Control: max-age=0
    X-Frame-Options: ALLOW
    Set-Cookie: csrftoken=UVJZ87XZYIC88JWdVAs6Dtlnt55pexFJ; expires=Wed, 29-Jul-2015 06:56:40 GMT; Max-Age=31449600; Path=/
    Set-Cookie: sessionid=518201660eb430fd9eeff9723c29dbb1; expires=Wed, 13-Aug-2014 06:56:40 GMT; httponly; Max-Age=1209600; Path=/
    Content-Encoding: gzip


http://211.68.39.82/public_api/api-auth/login/

::

    POST /public_api/api-auth/login/ HTTP/1.1
    Host: 211.68.39.82
    User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
    Accept-Language: zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3
    Accept-Encoding: gzip, deflate
    Referer: http://211.68.39.82/public_api/api-auth/login/
    Cookie: csrftoken=UVJZ87XZYIC88JWdVAs6Dtlnt55pexFJ; sessionid=518201660eb430fd9eeff9723c29dbb1
    Connection: keep-alive
    Content-Type: application/x-www-form-urlencoded
    Content-Length: 105
    csrfmiddlewaretoken=UVJZ87XZYIC88JWdVAs6Dtlnt55pexFJ&username=iflab&password=bistu123&next=&submit=Log+in
    HTTP/1.1 302 FOUND
    Server: nginx/1.1.19
    Date: Wed, 30 Jul 2014 06:57:13 GMT
    Content-Type: text/html; charset=utf-8
    Transfer-Encoding: chunked
    Connection: keep-alive
    Content-Language: zh-cn
    Expires: Wed, 30 Jul 2014 06:57:13 GMT
    Vary: Accept-Language, Cookie
    Last-Modified: Wed, 30 Jul 2014 06:57:13 GMT
    Location: http://211.68.39.82/accounts/login
    Cache-Control: max-age=0
    X-Frame-Options: ALLOW
    Set-Cookie: sessionid=7c638e43d9faed90d041cdec9412dfcf; expires=Wed, 13-Aug-2014 06:57:13 GMT; httponly; Max-Age=1209600; Path=/


 
用户信息
========


http://211.68.39.82/public_api/my_user_info

User Detail
-----------
Read-only information about our User.

This will be where users are redirected to after API login and will serve as a place to list all useful resources this user can access.

::

    GET /public_api/users/iflab
    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    {
        "id": 5, 
        "username": "iflab", 
        "email": "iflab@bistu.edu.cn", 
        "name": "iflab", 
        "course_enrollments": "http://211.68.39.82/public_api/users/iflab/course_enrollments/"
    }



用户课程列表
=============

"course_enrollments": "http://211.68.39.82/public_api/users/iflab/course_enrollments/"

User Course Enrollments List
----------------------------

Read-only list of courses that this user is enrolled in.

::

    GET /public_api/users/iflab/course_enrollments/
    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    [
        {
            "created": "2014-07-19T08:57:41Z", 
            "mode": "honor", 
            "is_active": true, 
            "course": {
                "course_about": "http://211.68.39.82/public_api/course_info/edX+Open_DemoX+edx_demo_course/about", 
                "course_updates": "http://211.68.39.82/public_api/course_info/edX+Open_DemoX+edx_demo_course/updates", 
                "number": "Open_DemoX", 
                "org": "edX", 
                "video_outline": "http://211.68.39.82/public_api/video_outlines/edX+Open_DemoX+edx_demo_course", 
                "id": "edX+Open_DemoX+edx_demo_course", 
                "latest_updates": {
                    "video": null
                }, 
                "end": null, 
                "name": "edX Demonstration Course", 
                "course_handouts": "http://211.68.39.82/public_api/course_info/edX+Open_DemoX+edx_demo_course/handouts", 
                "start": "1970-01-01T05:00:00Z", 
                "course_image": "/c4x/edX/Open_DemoX/asset/images_course_image.jpg"
            }
        }
    ]



Course About Detail
-------------------

Notes:

"status": "new" if course.is_newish else None

::

    GET /public_api/course_info/edX+Open_DemoX+edx_demo_course/about
    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    {
        "status": null, 
        "title": "edX Demonstration Course", 
        "short_description": "", 
        "overview": "<section class=\"about\">\n   <h2>About This Course</h2>\n   <p>Include your long course description here. The long course description should contain 150-400 words.</p>\n\n   <p>This is paragraph 2 of the long course description. Add more paragraphs as needed. Make sure to enclose them in paragraph tags.</p>\n </section>\n\n <section class=\"prerequisites\">\n   <h2>Prerequisites</h2>\n   <p>Add information about course prerequisites here.</p>\n </section>\n\n <section class=\"course-staff\">\n   <h2>Course Staff</h2>\n   <article class=\"teacher\">\n     <div class=\"teacher-image\">\n       <img src=\"/static/images/pl-faculty.png\" align=\"left\" style=\"margin:0 20 px 0\">\n     </div>\n\n     <h3>Staff Member #1</h3>\n     <p>Biography of instructor/staff member #1</p>\n   </article>\n\n   <article class=\"teacher\">\n     <div class=\"teacher-image\">\n       <img src=\"/static/images/pl-faculty.png\" align=\"left\" style=\"margin:0 20 px 0\">\n     </div>\n\n     <h3>Staff Member #2</h3>\n     <p>Biography of instructor/staff member #2</p>\n   </article>\n </section>\n\n <section class=\"faq\">\n   <section class=\"responses\">\n     <h2>Frequently Asked Questions</h2>\n     <article class=\"response\">\n       <h3>Do I need to buy a textbook?</h3>\n       <p>No, a free online version of Chemistry: Principles, Patterns, and Applications, First Edition by Bruce Averill and Patricia Eldredge will be available, though you can purchase a printed version (published by FlatWorld Knowledge) if you\u2019d like.</p>\n     </article>\n\n     <article class=\"response\">\n       <h3>Question #2</h3>\n       <p>Your answer would be displayed here.</p>\n     </article>\n   </section>\n </section>", 
        "university": "edX", 
        "start-date": "1970/01/01", 
        "course-number": "edX/Open_DemoX/edx_demo_course", 
        "course_image_url": "/c4x/edX/Open_DemoX/asset/images_course_image.jpg"
    }


Course Updates List
-------------------

Notes:

This only works for new-style course updates and is not the older freeform format.

::

    GET /public_api/course_info/edX+Open_DemoX+edx_demo_course/updates
    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    []


Course Handouts List
--------------------

Please just render this in an HTML view for now.

::

    GET /public_api/course_info/edX+Open_DemoX+edx_demo_course/handouts
    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    {
        "handouts_html": "\n    \n    <ol class=\"treeview-handoutsnav\">\n      <li><a href=\"/static/demoPDF.pdf\"> Example handout </a> </li>\n    \n   </ol>\n\n  \n  \n"
    }



课程视频信息
============

"video_outline": "http://211.68.39.82/public_api/video_outlines/edX+Open_DemoX+edx_demo_course",

Video Summary List
------------------

::

    GET /public_api/video_outlines/edX+Open_DemoX+edx_demo_course
    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    [
        {
            "section_url": "http://211.68.39.82/courses/edX/Open_DemoX/edx_demo_course/courseware/d8a6192ade314473a78242dfeedfbf5b/edx_introduction/", 
            "path": [
                {
                    "category": "chapter", 
                    "name": "Introduction"
                }, 
                {
                    "category": "sequential", 
                    "name": "Demo Course Overview"
                }, 
                {
                    "category": "vertical", 
                    "name": "Introduction: Video and Sequences"
                }
            ], 
            "named_path": [
                "Introduction", 
                "Demo Course Overview"
            ], 
            "summary": {
                "category": "video", 
                "name": "Welcome!", 
                "video_url": "https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJSP13-H010000_100.mp4", 
                "video_thumbnail_url": null, 
                "duration": null, 
                "id": "edX+Open_DemoX+edx_demo_course+video+0b9e39477cf34507a7a48f74be381fdd", 
                "size": 200000000
            }
        }, 
        {
            "section_url": "http://211.68.39.82/courses/edX/Open_DemoX/edx_demo_course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
            "path": [
                {
                    "category": "chapter", 
                    "name": "Example Week 1: Getting Started"
                }, 
                {
                    "category": "sequential", 
                    "name": "Lesson 1 - Getting Started"
                }, 
                {
                    "category": "vertical", 
                    "name": "Working with Videos"
                }
            ], 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "name": "Building a Computer Memory Element", 
                "video_url": "", 
                "video_thumbnail_url": null, 
                "duration": null, 
                "id": "edX+Open_DemoX+edx_demo_course+video+3302549fc54048ffba298bad96299f8f", 
                "size": 200000000
            }
        }, 
        {
            "section_url": "http://211.68.39.82/courses/edX/Open_DemoX/edx_demo_course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
            "path": [
                {
                    "category": "chapter", 
                    "name": "Example Week 1: Getting Started"
                }, 
                {
                    "category": "sequential", 
                    "name": "Lesson 1 - Getting Started"
                }, 
                {
                    "category": "vertical", 
                    "name": "Video Demonstrations"
                }
            ], 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "name": "Biology Demonstration", 
                "video_url": "", 
                "video_thumbnail_url": null, 
                "duration": null, 
                "id": "edX+Open_DemoX+edx_demo_course+video+ab98b0e385e64445ae97e730ffdf17e7", 
                "size": 200000000
            }
        }, 
        {
            "section_url": "http://211.68.39.82/courses/edX/Open_DemoX/edx_demo_course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
            "path": [
                {
                    "category": "chapter", 
                    "name": "Example Week 1: Getting Started"
                }, 
                {
                    "category": "sequential", 
                    "name": "Lesson 1 - Getting Started"
                }, 
                {
                    "category": "vertical", 
                    "name": "Video Presentation Styles"
                }
            ], 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "name": "Connecting a Circuit and a Circuit Diagram", 
                "video_url": "", 
                "video_thumbnail_url": null, 
                "duration": null, 
                "id": "edX+Open_DemoX+edx_demo_course+video+636541acbae448d98ab484b028c9a7f6", 
                "size": 200000000
            }
        }
    ]





video_url
---------

::


    "video_url": "https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJSP13-H010000_100.mp4", 
