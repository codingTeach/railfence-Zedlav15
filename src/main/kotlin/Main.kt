package org.example

import javax.swing.JOptionPane

fun main() {
    var option: Int

    do {

        option = JOptionPane.showInputDialog(
            "**** MENÚ ****\n1. Cifrar\n2. Descifrar\n3. Salir"
        )?.toIntOrNull() ?: 3

        when (option) {
            1 -> {
                val mensajeOriginal: String =
                    JOptionPane.showInputDialog("Dame el mensaje a cifrar:") ?: ""

                JOptionPane.showMessageDialog(
                    null, "El mensaje es: $mensajeOriginal", "Resultado", JOptionPane.INFORMATION_MESSAGE
                )

                val arreglo0 = ArrayList<Char>()
                val arreglo1 = ArrayList<Char>()
                val arreglo2 = ArrayList<Char>()
                var flag = false

                var i = 0

                for (a in mensajeOriginal) {
                    when (i) {
                        0 -> arreglo0.add(a)
                        1 -> arreglo1.add(a)
                        2 -> arreglo2.add(a)
                    }

                    if (i == 2) {
                        flag = true
                    } else if (i == 0) {
                        flag = false
                    }

                    if (flag) {
                        i--
                    } else {
                        i++
                    }
                }


                JOptionPane.showMessageDialog(
                    null, "Arreglo 0: $arreglo0\nArreglo 1: $arreglo1\nArreglo 2: $arreglo2",
                    "Resultado", JOptionPane.INFORMATION_MESSAGE
                )


                val mensajeCifrado = arreglo0 + arreglo1 + arreglo2
                JOptionPane.showMessageDialog(null, "Cadena Cifrada: $mensajeCifrado")
            }

            2 -> {
                val mensajeCifrado = JOptionPane.showInputDialog("Ingrese el mensaje cifrado:") ?: ""
                var numRieles: Int = 3
                val rieles = List(numRieles) { ArrayList<Char>() }
                val posiciones = mutableListOf<Int>()
                val longitud = mensajeCifrado.length


                var i = 0
                var bajando = true
                for (pos in mensajeCifrado.indices) {
                    posiciones.add(i)

                    if (bajando) {
                        i++
                        if (i == numRieles) {
                            i -= 2
                            bajando = false
                        }
                    } else {
                        i--
                        if (i < 0) {
                            i += 2
                            bajando = true
                        }
                    }
                }


                var index = 0
                for (fila in 0 until numRieles) {
                    for (col in posiciones.indices) {
                        if (posiciones[col] == fila && index < mensajeCifrado.length) {
                            rieles[fila].add(mensajeCifrado[index++])
                        }
                    }
                }


                val mensajeDescifrado = StringBuilder()
                i = 0
                bajando = true

                for (pos in mensajeCifrado.indices) {
                    mensajeDescifrado.append(rieles[posiciones[pos]].removeAt(0))

                    if (bajando) {
                        i++
                        if (i == numRieles) {
                            i -= 2
                            bajando = false
                        }
                    } else {
                        i--
                        if (i < 0) {
                            i += 2
                            bajando = true
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Cadena Cifrada: $mensajeDescifrado")
            }

            3 -> {
                JOptionPane.showMessageDialog(null, "Saliendo del programa")
            }

            else -> {
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.")
            }
        }
    } while (option != 3)
}

