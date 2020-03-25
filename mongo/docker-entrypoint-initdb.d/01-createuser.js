let error = true

let res = [
    db.create( { create: '@database@' } ),
    db.createUser( {
        user: '@user@',
        pwd: '@password@',
        roles: [
            {
                role: 'readWrite',
                db: '@database@'
            }
        ]
    })
]

printjson(res)

if (error) {
    print('Error, exiting')
    quit(1)
}
