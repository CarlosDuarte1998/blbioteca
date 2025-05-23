   $(document).ready(function () {

        $('.tabla_dinamica').DataTable({
            "order": [
                [0, "desc"]
            ],
            dom: 'Bfrtip',
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print', 'colvis'
            ],
            language: {
                url: '//cdn.datatables.net/plug-ins/1.12.1/i18n/es-ES.json'
            },
            "lengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "All"]
            ],
            "pageLength": 10,
            "searching": true,
            "paging": true,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": false
        });




        $('.select_user').change(function () {
            var selectedValue = $(this).val();
            if (selectedValue === '0') {
                console.log('Prueba');
            } else {
                var duis = $('.user_prestamo').map(function () {
                    return $(this).text().trim();
                }).get();

                var dui = selectedValue;
                //Ver si el dui ya existe mas de 4 veces

                var count = 0;
                for (var i = 0; i < duis.length; i++) {
                    if (duis[i] === dui) {
                        count++;
                    }
                }

                if (count >= 4) {
                    alert('El usuario ya tiene 4 prestamos activos');
                    $(this).val('0');
                }


            }
        });

    });