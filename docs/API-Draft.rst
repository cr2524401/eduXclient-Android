OAuth2
======

::
    
    curl -X POST -d "grant_type=password&username=<user_name>&password=<password>" \
    http://<client_id>:<client_secret>@59.64.64.24/oauth2/access_token

::
    
    {"access_token": "b4d4f3f78ded4e4e3c207db990cc394b462a17f0", "token_type": "Bearer", "expires_in": 2591999, "scope": ""}

::  
    
    curl -H "Authorization: Bearer <your_access_token>" \
    http://59.64.64.24/api/mobile/v0.5/users/<user_name>/

::
    
    {"id": 5, "username": "iflab", "email": "iflab@bistu.edu.cn", "name": "iflab", "course_enrollments": "http://localhost/api/mobile/v0.5/users/iflab/course_enrollments/"}


用户信息
========

http://59.64.64.24/api/mobile/v0.5/users/iflab

User Detail
-----------
Read-only information about our User.

This will be where users are redirected to after API login and will serve as a place to list all useful resources this user can access.

::
  
    GET /api/mobile/v0.5/users/iflab

::

    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    {
        "id": 5, 
        "username": "iflab", 
        "email": "iflab@bistu.edu.cn", 
        "name": "iflab", 
        "course_enrollments": "http://59.64.64.24/api/mobile/v0.5/users/iflab/course_enrollments/"
    }


用户课程列表
=============

"course_enrollments": "http://59.64.64.24/api/mobile/v0.5/users/iflab/course_enrollments/"

User Course Enrollments List
----------------------------

Read-only list of courses that this user is enrolled in.

::

    GET /api/mobile/v0.5/users/iflab/course_enrollments/

::

    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    [
        {
            "created": "2014-09-19T05:27:48Z", 
            "mode": "honor", 
            "is_active": true, 
            "course": {
                "course_about": "http://59.64.64.24/api/mobile/v0.5/course_info/edX/DemoX/Demo_Course/about", 
                "course_updates": "http://59.64.64.24/api/mobile/v0.5/course_info/edX/DemoX/Demo_Course/updates", 
                "number": "DemoX", 
                "org": "edX", 
                "video_outline": "http://59.64.64.24/api/mobile/v0.5/video_outlines/courses/edX/DemoX/Demo_Course", 
                "id": "edX/DemoX/Demo_Course", 
                "latest_updates": {
                    "video": null
                }, 
                "end": null, 
                "name": "edX Demonstration Course", 
                "course_handouts": "http://59.64.64.24/api/mobile/v0.5/course_info/edX/DemoX/Demo_Course/handouts", 
                "start": "2013-02-05T05:00:00Z", 
                "course_image": "/c4x/edX/DemoX/asset/images_course_image.jpg"
            }
        }, 
        {
            "created": "2014-09-21T10:23:50Z", 
            "mode": "honor", 
            "is_active": true, 
            "course": {
                "course_about": "http://59.64.64.24/api/mobile/v0.5/course_info/course-v1:edXRe+DemoXedXRe+2014_T2/about", 
                "course_updates": "http://59.64.64.24/api/mobile/v0.5/course_info/course-v1:edXRe+DemoXedXRe+2014_T2/updates", 
                "number": "DemoXedXRe", 
                "org": "edXRe", 
                "video_outline": "http://59.64.64.24/api/mobile/v0.5/video_outlines/courses/course-v1:edXRe+DemoXedXRe+2014_T2", 
                "id": "course-v1:edXRe+DemoXedXRe+2014_T2", 
                "latest_updates": {
                    "video": null
                }, 
                "end": null, 
                "name": "edX Demonstration Course Re Run", 
                "course_handouts": "http://59.64.64.24/api/mobile/v0.5/course_info/course-v1:edXRe+DemoXedXRe+2014_T2/handouts", 
                "start": "2030-01-01T00:00:00Z", 
                "course_image": "/asset-v1:edXRe+DemoXedXRe+2014_T2+type@asset+block@images_course_image.jpg"
            }
        }, 
        {
            "created": "2014-09-24T06:45:58Z", 
            "mode": "honor", 
            "is_active": true, 
            "course": {
                "course_about": "http://59.64.64.24/api/mobile/v0.5/course_info/test/Cs11/1014/about", 
                "course_updates": "http://59.64.64.24/api/mobile/v0.5/course_info/test/Cs11/1014/updates", 
                "number": "Cs11", 
                "org": "test", 
                "video_outline": "http://59.64.64.24/api/mobile/v0.5/video_outlines/courses/test/Cs11/1014", 
                "id": "test/Cs11/1014", 
                "latest_updates": {
                    "video": null
                }, 
                "end": null, 
                "name": "MOOCs\u5236\u4f5c\u4e0e\u8fd0\u8425", 
                "course_handouts": "http://59.64.64.24/api/mobile/v0.5/course_info/test/Cs11/1014/handouts", 
                "start": "2014-07-17T00:00:00Z", 
                "course_image": "/c4x/test/Cs11/asset/images_course_image.jpg"
            }
        }
    ]



Course About Detail
-------------------

Notes:

::

    GET /api/mobile/v0.5/course_info/edX/DemoX/Demo_Course/about

::

    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    {
        "overview": "<section class=\"about\">\n   <h2>About This Course</h2>\n   <p>Include your long course description here. The long course description should contain 150-400 words.</p>\n\n   <p>This is paragraph 2 of the long course description. Add more paragraphs as needed. Make sure to enclose them in paragraph tags.</p>\n </section>\n\n <section class=\"prerequisites\">\n   <h2>Prerequisites</h2>\n   <p>Add information about course prerequisites here.</p>\n </section>\n\n <section class=\"course-staff\">\n   <h2>Course Staff</h2>\n   <article class=\"teacher\">\n     <div class=\"teacher-image\">\n       <img src=\"/static/images/pl-faculty.ffeb747183dd.png\" align=\"left\" style=\"margin:0 20 px 0\">\n     </div>\n\n     <h3>Staff Member #1</h3>\n     <p>Biography of instructor/staff member #1</p>\n   </article>\n\n   <article class=\"teacher\">\n     <div class=\"teacher-image\">\n       <img src=\"/static/images/pl-faculty.ffeb747183dd.png\" align=\"left\" style=\"margin:0 20 px 0\">\n     </div>\n\n     <h3>Staff Member #2</h3>\n     <p>Biography of instructor/staff member #2</p>\n   </article>\n </section>\n\n <section class=\"faq\">\n   <section class=\"responses\">\n     <h2>Frequently Asked Questions</h2>\n     <article class=\"response\">\n       <h3>Do I need to buy a textbook?</h3>\n       <p>No, a free online version of Chemistry: Principles, Patterns, and Applications, First Edition by Bruce Averill and Patricia Eldredge will be available, though you can purchase a printed version (published by FlatWorld Knowledge) if you\u2019d like.</p>\n     </article>\n\n     <article class=\"response\">\n       <h3>Question #2</h3>\n       <p>Your answer would be displayed here.</p>\n     </article>\n   </section>\n </section>"
    }


Course Updates List
-------------------

Notes:

This only works for new-style course updates and is not the older freeform format.

::

    GET /api/mobile/v0.5/course_info/edX/DemoX/Demo_Course/updates

::

    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    []


Course Handouts List
--------------------

Please just render this in an HTML view for now.

::

    GET /api/mobile/v0.5/course_info/edX/DemoX/Demo_Course/handouts

::

    HTTP 200 OK
    Content-Type: application/json
    Vary: Accept
    Allow: GET, HEAD, OPTIONS

    {
        "handouts_html": "\n    \n    <ol class=\"treeview-handoutsnav\">\n      <li><a href=\"/static/demoPDF.pdf\"> Example handout </a> </li>\n    \n   </ol>\n\n"
    }


课程视频信息
============

"video_outline": "http://59.64.64.24/api/mobile/v0.5/video_outlines/courses/edX/DemoX/Demo_Course"

A list of all Videos in this Course that the user has access to.

Video Summary List
------------------

::

  GET /api/mobile/v0.5/video_outlines/courses/edX/DemoX/Demo_Course

::

HTTP 200 OK
Content-Type: application/json
Vary: Accept
Allow: GET, HEAD, OPTIONS

    [
        {
            "section_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/d8a6192ade314473a78242dfeedfbf5b/edx_introduction/", 
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
            "unit_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/d8a6192ade314473a78242dfeedfbf5b/edx_introduction/1", 
            "named_path": [
                "Introduction", 
                "Demo Course Overview"
            ], 
            "summary": {
                "category": "video", 
                "video_thumbnail_url": null, 
                "language": "en", 
                "name": "Welcome!", 
                "video_url": "https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJSP13-H010000_100.mp4", 
                "duration": null, 
                "transcripts": {
                    "en": "http://59.64.64.24/api/mobile/v0.5/video_outlines/transcripts/edX/DemoX/Demo_Course/0b9e39477cf34507a7a48f74be381fdd/en"
                }, 
                "id": "i4x://edX/DemoX/video/0b9e39477cf34507a7a48f74be381fdd", 
                "size": 0
            }
        }, 
        {
            "section_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
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
            "unit_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/2", 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "video_thumbnail_url": null, 
                "language": "en", 
                "name": "Science and Cooking Chef Profile: JOS\u00c9 ANDR\u00c9S", 
                "video_url": "", 
                "duration": null, 
                "transcripts": {
                    "en": "http://59.64.64.24/api/mobile/v0.5/video_outlines/transcripts/edX/DemoX/Demo_Course/7e9b434e6de3435ab99bd3fb25bde807/en"
                }, 
                "id": "i4x://edX/DemoX/video/7e9b434e6de3435ab99bd3fb25bde807", 
                "size": 0
            }
        }, 
        {
            "section_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
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
                    "name": "Videos on edX"
                }
            ], 
            "unit_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/3", 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "video_thumbnail_url": null, 
                "language": "en", 
                "name": "Video", 
                "video_url": "https://s3.amazonaws.com/edx-course-videos/harvard-heroes/HARHEROESP13-H00700_100.mp4", 
                "duration": null, 
                "transcripts": {
                    "en": "http://59.64.64.24/api/mobile/v0.5/video_outlines/transcripts/edX/DemoX/Demo_Course/5c90cffecd9b48b188cbfea176bf7fe9/en"
                }, 
                "id": "i4x://edX/DemoX/video/5c90cffecd9b48b188cbfea176bf7fe9", 
                "size": 0
            }
        }, 
        {
            "section_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
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
            "unit_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/4", 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "video_thumbnail_url": null, 
                "language": "en", 
                "name": "Physics Demonstration", 
                "video_url": "https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJT313-H0107R1_100.mp4", 
                "duration": null, 
                "transcripts": {}, 
                "id": "i4x://edX/DemoX/video/dc37305d4dc042ebb6fdfd13911a8ae5", 
                "size": 0
            }
        }, 
        {
            "section_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/", 
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
            "unit_url": "http://59.64.64.24/courses/edX/DemoX/Demo_Course/courseware/interactive_demonstrations/19a30717eff543078a5d94ae9d6c18a5/6", 
            "named_path": [
                "Example Week 1: Getting Started", 
                "Lesson 1 - Getting Started"
            ], 
            "summary": {
                "category": "video", 
                "video_thumbnail_url": null, 
                "language": "en", 
                "name": "Connecting a Circuit and a Circuit Diagram", 
                "video_url": "https://s3.amazonaws.com/edx-course-videos/mit-6002x/6002-Tutorial-00010_100.mov", 
                "duration": null, 
                "transcripts": {}, 
                "id": "i4x://edX/DemoX/video/636541acbae448d98ab484b028c9a7f6", 
                "size": 0
            }
        }
    ]



video_url
---------

::


    "video_url": "https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJSP13-H010000_100.mp4",
