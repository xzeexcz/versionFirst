function loadVideosForTable() {
    $.ajax({
        url: '/videos/all',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            let html = '';
            for (let i = 0; i < json.length; i++) {
                let video = json[i];
                html += `
                <tr>
                <td>${video.videoSnippetDTO.title}</td>
                <td>${video.videoStatisticsDTO.viewsCount}</td>
                <td>${video.videoStatisticsDTO.likesCount}</td>
                </tr>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#videoTable').html(html);
        }
    });
}
function loadMoviesForTable() {
    $.ajax({
        url: '/home/dto',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            let html = '';
            for (let i = 0; i < json.length; i++) {
                let movie = json[i];
                html += `
                <tr>
                <td>${movie.movieSnippetDTO.title}</td>
                <td>${movie.movieStatisticsDTO.viewsCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</td>
                <td>${movie.movieStatisticsDTO.likesCount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</td>
                <td><button class="btn btn-sm btn-primary" onclick="openModalMovie('${encodeURIComponent(movie.movieId)}')">EDIT</button></td>
                <td><button class="btn btn-sm btn-danger" onclick="openModalMovieDelete('${encodeURIComponent(movie.movieId)}')">DELETE</button></td>
                </tr>
            `;
            }
            // Добавляем сгенерированный HTML на страницу
            $('#movieTable').html(html);
        }
    });
}
function openModalMovie(movieId) {
    var movieUrl = decodeURIComponent(movieId);
    sessionStorage.setItem('movie_id', movieUrl);
    var url = '/home/dto/'+movieUrl;
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function(movie) {
            $('#movieTitleTab').val(movie.movieSnippetDTO.title);
            $('#movieDescrTab').val(movie.movieSnippetDTO.description);
            $('#movieLikesTab').val(movie.movieStatisticsDTO.likesCount);
            $('#movieViewsTab').val(movie.movieStatisticsDTO.viewsCount);

            // Откройте модальное окно
            $('#editMovieModal').modal('show');
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function openModalMovieDelete(movieId) {
    var movieUrl = decodeURIComponent(movieId);
    sessionStorage.setItem('movie_url', movieUrl);
    $('#deleteMovieModal').modal('show');

}
function deleteMovie() {
    var movieUrl = sessionStorage.getItem('movie_url');
    var url2 = '/home/delete?movie_url='+movieUrl;
    $.ajax({
        url: url2,
        type: 'DELETE',
        dataType: 'text',
        success: function (response) {
            if(response==='Success') {
                $('#deleteMovieModal').modal('hide');
                loadMoviesForTable();
            }
        },
        error: function (error) {
            console.error(error);
        }
    });
}

function saveChangesMovie() {
    var movieUrl = sessionStorage.getItem('movie_id');
    var newMovieTitle = document.getElementById('movieTitleTab').value;
    var newMovieDescription = document.getElementById('movieDescrTab').value;
    var newMovieViewsCount = document.getElementById('movieViewsTab').value;
    var newMovieLikesCount = document.getElementById('movieLikesTab').value;

    if (newMovieTitle !== '' && newMovieDescription !== '' && newMovieViewsCount !== '' && newMovieLikesCount !== '') {

        var newInfo = {
            movieTitle: newMovieTitle,
            movieDescription : newMovieDescription,
            movieViewsCount : newMovieViewsCount,
            movieLikesCount : newMovieLikesCount
        }

        $.ajax({
            url: '/home/update/'+movieUrl,
            type: 'PUT',
            dataType: 'json',
            data: newInfo,
            success: function (response) {
                $('#editMovieModal').modal('hide');
                loadMoviesForTable();
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        })
    } else {
        alert('Please, complete all fields!');
    }
}