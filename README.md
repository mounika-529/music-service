# music-service


============SWAGGER URL========================================================================
http://localhost:8080/swagger-ui.html
=========================================ARTIST CONTROLLER=====================================
1 ---------Create Artist-------POST-----
Url: http://localhost:8080/artist/create
Sample Request:
{
	"artistId": "ART100",
	"artistName": "Vijay Thalapathi",
	"albumList":[
		{
			"albumId": "ALB200",
			"albumTitle": "Master",
			"yearOfRelease": "2020-06-24",
			"genres": "Melody",
			"trackList":[
				{
					"trackId": 300,
					"title": "songs"
				}
			]
		}
	]
}

2 -----------Update Artist-------PUT-----
Url: http://localhost:8080/artist/update
Sample Request:
{
	"artistId": "ART100",
	"artistName": "Vijay Thalapathi",
	"albumList":[
		{
			"albumId": "ALB200",
			"albumTitle": "AACHARYA",
			"yearOfRelease": "2020-06-24",
			"genres": "Melody",
			"trackList":[
				{
					"trackId": 300,
					"title": "songs"
				}
			]
		}
	]
}

3 -----------FindByArtistId-------GET-----
Url: http://localhost:8080/artist/findByArtistId/ART100

Sample Response:
{
    "artistId": "ART100",
    "artistName": "Vijay Thalapathi",
    "albumList": [
        {
            "albumId": "ALB200",
            "albumTitle": "AACHARYA",
            "yearOfRelease": "2020-06-24",
            "genres": "Melody",
            "trackList": [
                {
                    "trackId": 300,
                    "title": "songs"
                }
            ]
        }
    ]
}

4 ----------FindByArtistName--------GET-----
Url: localhost:8080/artist/findByArtistName/Vijay Thalapathi

Sample Response:
{
    "artistId": "ART100",
    "artistName": "Vijay Thalapathi",
    "albumList": [
        {
            "albumId": "ALB200",
            "albumTitle": "AACHARYA",
            "yearOfRelease": "2020-06-24",
            "genres": "Melody",
            "trackList": [
                {
                    "trackId": 300,
                    "title": "songs"
                }
            ]
        }
    ]
}

5 ---------findAllArtists-------GET--------
Url: localhost:8080/artist/findAllArtists?pageNo=0&pageSize=10&sortByOrder=ASC

Sample Response:
{
    "artistId": "ART100",
    "artistName": "Vijay Thalapathi",
    "albumList": [
        {
            "albumId": "ALB200",
            "albumTitle": "AACHARYA",
            "yearOfRelease": "2020-06-24",
            "genres": "Melody",
            "trackList": [
                {
                    "trackId": 300,
                    "title": "songs"
                }
            ]
        }
    ]
}

6 ---------findAllArtists-------GET--------
Url: http://localhost:8080/artist/ART100/albums

Sample Response:
[
    {
        "albumId": "ALB200",
        "albumTitle": "Master",
        "yearOfRelease": "2020-06-24",
        "genres": "Melody",
        "trackList": [
            {
                "trackId": 300,
                "title": "songs"
            }
        ]
    }
]


=========================================ALBUM CONTROLLER=====================================

1 ---------findByAlbumId-------GET--------
Url: http://localhost:8080/album/findByAlbumId/ALB200

Sample Response:
{
    "albumId": "ALB200",
    "albumTitle": "Master",
    "yearOfRelease": "2020-06-24",
    "genres": "Melody",
    "trackList": [
        {
            "trackId": 300,
            "title": "songs"
        }
    ]
}

2 ---------findByGenre-------GET--------
Url: http://localhost:8080/album/findByGenre/Melody
Sample Response:
[
    {
        "albumId": "ALB200",
        "albumTitle": "Master",
        "yearOfRelease": "2020-06-24",
        "genres": "Melody",
        "trackList": [
            {
                "trackId": 300,
                "title": "songs"
            }
        ]
    }
]

3 ---------findAllAlbums-------GET--------
Url: localhost:8080/album/findAllAlbums?pageNo=0&pageSize=10&sortByOrder=ASC

Sample Response:
[
    {
        "albumId": "ALB200",
        "albumTitle": "Master",
        "yearOfRelease": "2020-06-24",
        "genres": "Melody",
        "trackList": [
            {
                "trackId": 300,
                "title": "songs"
            }
        ]
    }
]
music-service-req and res.txt
Displaying music-service-req and res.txt.
