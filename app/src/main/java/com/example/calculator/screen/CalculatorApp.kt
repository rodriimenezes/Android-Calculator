package com.example.calculator.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorApp(modifier: Modifier = Modifier){
    var numBuf by remember { mutableStateOf("0") }
    var numBuf2 by remember { mutableStateOf("0") }
    var numView by remember { mutableStateOf("0") }
    var opcode by remember { mutableIntStateOf(0) }

    val btns: List<String> = listOf("C","mod","%","/","7","8","9","*","4","5","6","-","1","2","3","+","+/-","0",".","=")

    var colorFirstOperetor: Color = Color.Transparent
    if(numBuf2 != "0")
        colorFirstOperetor = MaterialTheme.colorScheme.surfaceBright

    Surface(modifier = modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom, modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 64.dp, horizontal = 16.dp)) {
            Text(text = numBuf2, fontSize = 36.sp, color = colorFirstOperetor, lineHeight = 50.sp, maxLines = 1, modifier = Modifier.padding(16.dp))
            Text(text = numBuf, fontSize = 48.sp, lineHeight = 50.sp, maxLines = 1, modifier = Modifier.padding(16.dp))
            TextButton(onClick = {
                if(numBuf.length == 1){
                    numBuf = "0"
                }else{
                    numBuf = numBuf.dropLast(1)
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf = "0"
                                numBuf2 = "0" },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                            modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[0], color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf2 = numBuf
                                numBuf = "0"
                                opcode = 1
                            },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                            modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[1], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf = (numBuf.toDouble() / 100.0).toString()
                            }, shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[2], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf2 = numBuf
                                numBuf = "0"
                                opcode = 2
                            },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                            modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[3], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "7"
                                } else {
                                    numBuf += "7"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[4],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            ))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "8"
                                } else {
                                    numBuf += "8"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[5],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            ))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "9"
                                } else {
                                    numBuf += "9"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[6],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            )
                        )
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf2 = numBuf
                                numBuf = "0"
                                opcode = 3
                            }, shape = CircleShape,colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[7], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "4"
                                } else {
                                    numBuf += "4"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[8],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            )
                        )
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "5"
                                } else {
                                    numBuf += "5"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[9],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            ))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "6"
                                } else {
                                    numBuf += "6"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[10],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            ))
                    }

                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf2 = numBuf
                                numBuf = "0"
                                opcode = 4
                            }, shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[11], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "1"
                                } else {
                                    numBuf += "1"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[12],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            )
                        )
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "2"
                                } else {
                                    numBuf += "2"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[13], color = Color.White,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf == "0") {
                                    numBuf = "3"
                                } else {
                                    numBuf += "3"
                                }
                            }, shape = CircleShape, modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[14],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf2 = numBuf
                                numBuf = "0"
                                opcode = 5
                            }, shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[15], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                numBuf = (numBuf.toDouble() * -1.0).toString()
                                if(numBuf.toDouble().rem(1).equals(0.0) || numBuf.toDouble().rem(1).equals(-0.0)){
                                    numBuf = numBuf.toDouble().toInt().toString()
                                }
                            }, shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[16], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (numBuf != "0") {
                                    numBuf += "0"
                                }
                            },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(
                            text = btns[17],
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.align(
                                Center
                            )
                        )
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                if (!numBuf.contains(".")) {
                                    numBuf += "."
                                }
                            }, shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[18], color = MaterialTheme.colorScheme.primary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
                item {
                    Box {
                        Button(
                            onClick = {
                                when (opcode) {
                                    1 -> numBuf =
                                        (numBuf2.toDouble() % numBuf.toDouble()).toString()

                                    2 -> numBuf =
                                        (numBuf2.toDouble() / numBuf.toDouble()).toString()

                                    3 -> numBuf =
                                        (numBuf2.toDouble() * numBuf.toDouble()).toString()

                                    4 -> numBuf =
                                        (numBuf2.toDouble() - numBuf.toDouble()).toString()

                                    5 -> numBuf =
                                        (numBuf2.toDouble() + numBuf.toDouble()).toString()
                                }
                                if(numBuf.toDouble().rem(1).equals(0.0)){
                                    numBuf = numBuf.toDouble().toInt().toString()
                                }
                            }, shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSecondary), modifier = Modifier
                                .size(100.dp)
                                .padding(vertical = 16.dp, horizontal = 10.dp)
                        ) {}
                        Text(text = btns[19], color = MaterialTheme.colorScheme.secondary,fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.align(
                            Center))
                    }
                }
            }
        }
    }
}