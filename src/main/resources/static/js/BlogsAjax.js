function loadBlogs() {
    $.ajax({
        url: '/blogs/all',
        type: 'GET',
        dataType: 'json',
        async:false,
        success: function(response) {
            var html = '';
            for (var i = 0; i <= 5 ; i++) {
                var blog = response[i];
                html += '<div class="col-lg-12">';
                html += '<div class="gen-blog-post">';
                html += '<div class="gen-blog-contain">';
                html += '<div class="gen-post-meta">';

                html += '<ul>';
                html += '<li class="gen-post-author"><i class="fa fa-user"></i>' + blog.author.firstName + '</li>';
                html += '<li class="gen-post-meta"><i class="fa fa-calendar"></i>'+ blog.postDate +'</li>';
                html += '<li><i class="fa fa-tag"></i>'+ blog.categoriesList.map(function (name) { return name.categoryName}).join(", ") +'</li>';
                html += '</ul>';
                html += '</div>';

                html += '<h5 class="gen-blog-title"><a href="blog-single.html">'+ blog.title +'</a></h5>';
                html += '<p>'+ blog.description+ '</p>';

                html += '<div><a class="gen-button" onclick="blogDetails('+blog.id+')"><div class="gen-button-block"><span class="gen-button-text">Read More</span></div></a></div>'

                html += '</div>'; // третий
                html += '</div>'; // второй
                html += '</div>'; // первый
                $('.blog').append(html);
                html = '';


            }
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}
function blogDetails(id) {
    sessionStorage.setItem('blogId', id );
    window.location.href = "/blogs/"+id;
}
function getBlogDetailsById() {
    var blogId = sessionStorage.getItem('blogId');
    var url = '/blogs/all/'+blogId;
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            renderBlogDetails(result);
        }
    });
}
function renderBlogDetails(data) {
    var blogTitle = data.title;
    var blogDescription = data.description;
    var blogPostDate = formatPostDate(data.postDate);
    var authorName = data.author.firstName;
    $('#blogTitle').text(blogTitle);
    $('#blogDescription').text(blogDescription);
    $('#blogPostDate').text(blogPostDate);
    $('#blogAuthorName').text(authorName);
    $('#blogSubTitle').text(blogTitle);
    $('#blogTitle3').text(blogTitle);
}
function formatPostDate(postDate) {
    var date = new Date(postDate);
    var option = { day: 'numeric', month: 'short', year: 'numeric' };
    var formatDate = date.toLocaleDateString('en-US', option);
    return formatDate;
}
function PostComment() {
    var blogId = sessionStorage.getItem('blogId');
    var comment = document.getElementById('userComment').value;
    var currentDate = new Date();

    var info = {
        'blogs': {
            'id': blogId
        },
        'comment': comment,
        'postDate': currentDate
    }

    $.ajax({
        url: '/comments/add',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(info),
        contentType: 'application/json',
        success: function (response) {
            var html = '';
            html += '<div class="col-md-11 col-lg-9 col-xl-7">';
            html += '<div class="d-flex flex-start mb-4">';
            html += '<div class="card w-100">';
            html += '<div class="card-body p-4">';
            html += '<div class="">';
            html += '<h5>' + (response.users ? response.users.firstName + ' ' + response.users.lastName : 'Unknown') + '</h5>';
            html += '<p class="small" style="color: #cecfd1;">' + formatPostDate(response.postDate) + '</p>';
            html += '<textarea style="display: block; border: 2px solid rgb(22,22,22); color: #cecfd1; background: #161616">' + response.comment + '</textarea>';
            html += '</div>';
            html += '</div>';
            html += '</div>';
            html += '</div>';
            html += '</div>';
            $('.comment2').append(html);

            document.getElementById('userComment').value = '';

            $('.alert-success').show();
            setTimeout(function () {
                $('.alert-success').hide();
            }, 3000);
        },
        error: function (xhr, status, error) {
            $('.alert-danger').show();
            setTimeout(function () {
                $('.alert-danger').hide();
            }, 3000);

            console.log('AJAX Error:', error);
        }
    });
}


function loadComments() {
    var blogIdc = sessionStorage.getItem('blogId');
    $.ajax({
        url: '/comments/'+blogIdc,
        type: 'GET',
        dataType: 'json',
        async:false,
        success: function(comment) {
            var html = '';
            for (let i = 0; i < comment.length ; i++) {
                var currentComment = comment[i];
                html += '<div class="col-md-11 col-lg-9 col-xl-7">';
                html += '<div class="d-flex flex-start mb-4">';
                html += '<div class="card w-100">';
                html += '<div class="card-body p-4">';
                html += '<div class="">';
                html += '<h5>'+ currentComment.users.firstName + ' ' + currentComment.users.lastName + '</h5>'
                html += '<p class="small" style="color: #cecfd1;">'+  formatPostDate(currentComment.postDate) + '</p>';
                html += '<textarea style="display: block; border: 2px solid rgb(22,22,22); color: #cecfd1; background: #161616">'+ currentComment.comment + '</textarea>'
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                $('.comment2').append(html);
                html = '';
            }
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}
function loadLatestComments() {
    $.ajax({
        url: '/comments/'+blogIdc,
        type: 'GET',
        dataType: 'json',
        async:false,
        success: function(comment) {
            var html = '';
            for (let i = 0; i < comment.length ; i++) {
                var currentComment = comment[i];
                html += '<div class="col-md-11 col-lg-9 col-xl-7">';
                html += '<div class="d-flex flex-start mb-4">';
                html += '<div class="card w-100">';
                html += '<div class="card-body p-4">';
                html += '<div class="">';
                html += '<h5>'+ currentComment.users.firstName + ' ' + currentComment.users.lastName + '</h5>'
                html += '<p class="small" style="color: #cecfd1;">'+  formatPostDate(currentComment.postDate) + '</p>';
                html += '<textarea style="display: block; border: 2px solid rgb(22,22,22); color: #cecfd1; background: #161616">'+ currentComment.comment + '</textarea>'
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                $('.comment2').append(html);
                html = '';
            }
        },
        error: function(xhr, status, error) {
            console.log('AJAX Error:', error);
        }
    });
}