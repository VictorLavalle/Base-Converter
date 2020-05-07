#include<iostream>//Libreria Estandar de C++
#include <stdlib.h>//Libreria Para poder utilizar la funcion de limpiar Pantalla
#include<windows.h>//libreria Para poder utilizar adecuadamente la funcion gotoxy y el Sleep
#include<conio.h>//Libreria Para datos de Salida y Entrada en la Consola


//Declaracion  de Variables
void titulo_principal();//declaracion de la funcion para mostrar la priera pantalla
void cargando();//declaracion de la funcion para animacion
void gotoxy(int x,int y);//declaracion de la funcion para utlizar sistema de coordenas y movimiento con las teclas
void menu_principal();//declaracion de la funcion para mostrar las diferentes opciones
long signed int BaseADecimal(long signed int,long signed int);//Funcion Para Convertir de Cualquier Base a Decimal
long signed int DecimalABase(long signed int,long signed int);//Funcion Para Convertir de Decimal a Cualquier Decimal

//Funcion Main
int main() {
	
	system("title Sistema de Numeracion Posicional");
	system("color 0a");
	titulo_principal();
	menu_principal();
}


//Creacion de las Funciones
//Funcion Que Muestra Animacion de Carga
void cargando(){
	system("cls");
	printf("\n\n\n\t\t\tPorfavor Espere. Cargando...\n\n");
	printf("\t\t\t\t");
	for (int i=0;i<=15;i++)
		printf("%c",177);
	Sleep(150);
	printf("\r ");
	printf("\t\t\t\t");
	for (int i=0;i<=15;i++)
	{
		printf("%c",219);
		Sleep(200);
	}
}
//Funcion Para Establecer Coordenaas en el cuadro de juego
void gotoxy(int x,int y){ 
	//Generaba error al usarla libreria, así que al investigar buscamos la funcion que permite lo que necesitamos
	HANDLE hCon;
	hCon=GetStdHandle(STD_OUTPUT_HANDLE);
	COORD dwPos;
	dwPos.X=x;
	dwPos.Y=y;
	SetConsoleCursorPosition(hCon,dwPos);
}

//Funcion Para mostrar el Titulo principal
void titulo_principal(){
	system("cls");
	system("color 0a");
	int c=22,f=78;//Declaracion de las dimensiones
	for(int i=0 ; i<f ; i++){//Generar los bordes del cuadro de la interfaz
		gotoxy(i,0);
		printf("%c",178);
		gotoxy(i,c);
		printf("%c",178);
	}
	for(int i=0 ; i<=c ; i++){//Genera los bordes del Cuadro de la Interfaz
		gotoxy(0,i);
		printf("%c",178);
		gotoxy(f,i);
		printf("%c",178);
	}
	
	gotoxy(1,4);
	puts("           d8888 8888888b.        d8888        888  888    .d8888b. ");
	gotoxy(1,5);
	puts("          d88888 888  'Y88b      d88888        888  888   d88P  Y88b ");
	gotoxy(1,6);
	puts("         d88P888 888    888     d88P888      888888888888      .d88P ");
	gotoxy(1,7);
	puts("        d88P 888 888    888    d88P 888        888  888       8888" );
	gotoxy(1,8);
	puts("       d88P  888 888    888   d88P  888        888  888        'Y8b.");
	gotoxy(1,9);
	puts("      d88P   888 888    888  d88P   888      888888888888 888    888");
	gotoxy(1,10);
	puts("     d8888888888 888  .d88P d8888888888        888  888   Y88b  d88P ");
	gotoxy(1,11);
	puts("    d88P     888 8888888P' d88P     888        888  888    'Y8888P' ");
	gotoxy(2,17);
	puts("                     Oprima Cualquier Tecla Para Comenzar              \n");
	system("pause>null");
	system("cls");
}

//Funcion Para mostrar el menu principal
void menu_principal(){
	//Declaracion de Variables
	bool repetir=true;  //Para controlar el bucle del menu
	int c=22,f=78;//Declaracion de las dimensiones
	int opcion,respuesta;  //Variables para seleccionar en switch
	long signed int Base1,Base2,NumEnt,NumSal,Aux;
	
	
	//Interfaz Principal
	do{
		system("color 0a");
		system("cls");//Limpiar Pantalla
		for(int i=0 ; i<f ; i++){//Generar los bordes del cuadro de la interfaz
			gotoxy(i,0);
			printf("%c",178);
			gotoxy(i,c);
			printf("%c",178);
		}
		for(int i=0 ; i<=c ; i++){//Genera los bordes del Cuadro de la Interfaz
			gotoxy(0,i);
			printf("%c",178);
			gotoxy(f,i);
			printf("%c",178);
		}
		gotoxy(6,1);
		printf("\n\t **************** SISTEMA DE NUMERACION POSICIONAL ****************  \n");  //Titulo
		//Opciones
		gotoxy(31,5);printf("1. Comenzar");
		gotoxy(31,7);printf("2. Creditos");
		gotoxy(31,9);printf("0. Salir");
		gotoxy(26,14);printf("Opción: ");
		
		do{
			fflush(stdin);
			gotoxy(35,14);
			scanf("%d",&opcion);
		}while(opcion>=3 || opcion<0);
		fflush(stdin);
		system("cls");
		
		
		//Acciones a Realizar Segun la Opcion Seleccionada
		switch(opcion){
			
		case 1:
			//Comenzar la Capturacion y Conversion
			cargando();
			do{
			system("cls");//Limpia la Pantalla
			for(int i=0 ; i<f ; i++){//Generar los bordes del cuadro de la interfaz
				gotoxy(i,0);
				printf("%c",178);
				gotoxy(i,c);
				printf("%c",178);
			}
			for(int i=0 ; i<=c ; i++){//Genera los bordes del Cuadro de la Interfaz
				gotoxy(0,i);
				printf("%c",178);
				gotoxy(f,i);
				printf("%c",178);
			}
			fflush(stdin);
			gotoxy(15,3);printf("Número:");gotoxy(42,3);printf("en Base: ");gotoxy(25,6);printf("Base a Convertir:"); 
			do{
				gotoxy(23,3);fflush(stdin);scanf("%ld",&NumEnt);
			if(NumEnt<1){gotoxy(23,3);printf("              ");
			gotoxy(23,15);printf("*Dato Inválido!");gotoxy(23,15);Sleep(500);printf("                ");
			}}while(NumEnt<1);
			
			do{
			gotoxy(50,3);fflush(stdin);scanf("%ld",&Base1);if(Base1<2||Base1>16||Base1==11||Base1==12||Base1==13||Base1==14||Base1==15){gotoxy(50,3);printf("              ");
			gotoxy(23,15);printf("*Dato Inválido!");gotoxy(23,15);Sleep(500);printf("                ");
			}}while(Base1<2||Base1>16||Base1==11||Base1==12||Base1==13||Base1==14||Base1==15);
			
			do{
			gotoxy(42,6);fflush(stdin);scanf("%ld",&Base2);if(Base2<2||Base2>16||Base2==11||Base2==12||Base2==13||Base2==14||Base2==15);{gotoxy(42,6);printf("              ");
			}}while(Base2<2||Base2>16||Base2==11||Base2==12||Base2==13||Base2==14||Base2==15);
			
			//Si la base a Convertir es 10 se llama a la funcion que hace la conversion
			if(Base2==10){ NumSal=BaseADecimal(NumEnt,Base1);}
			
			else{
				//Si la Base del Numero Ingresado es Decimal entonces se llama a la funcion que lo convierte a la que se indica
				if(Base1==10){ NumSal=DecimalABase(NumEnt,Base2);}
				
				//Sino Ocurre alguno de eso casos directos se convierte el numero a Decimal y Posteriormente de Decimal a La Base Indicada
				else{
					Aux=BaseADecimal(NumEnt,Base1);
					NumSal=DecimalABase(Aux,Base2);
				}
			}
			gotoxy(42,6);printf("%ld",Base2);
			gotoxy(16,9);printf("El Numero %ld en Base %ld  Convertido a Base %ld es: %ld",NumEnt,Base1,Base2,NumSal);
			do{
			gotoxy(1,15);printf("  ¿Desea Convertir de Nuevo?: Si.(Oprima '1'+Enter)   No.(Oprima '0'+Enter)  ");gotoxy(3,17);printf(">>");
			fflush(stdin);//Limpia el Buffer de los Datos Almacenados
			gotoxy(6,17);scanf("%d",&respuesta);}while(respuesta>1||respuesta<0);
			}while(respuesta==1);
			
			break;
			
		case 2: //Creditos
			system("cls");
			system("color 0e");
			for(int i=0 ; i<f ; i++){//Generar los bordes del cuadro de la interfaz
				gotoxy(i,0);
				printf("%c",178);
				gotoxy(i,c);
				printf("%c",178);
			}
			for(int i=0 ; i<=c ; i++){//Genera los bordes del Cuadro de la Interfaz
				gotoxy(0,i);
				printf("%c",178);
				gotoxy(f,i);
				printf("%c",178);
			}
			gotoxy(5,1);
			printf("\n\n\t\t\t    A Project Made By:\n\n\t\t\t        *Victor Lavalle\n\n\t\t\t        *Eberth Mezeta\n\n\t\t\t        *Gabriel Islas\n\n\t\t\t        *Emilio Lara\n\n\t   Arquitectura de Computadoras 3er Sem. UADY, FMAT 2019");
			gotoxy(5,20); printf("<%c%cPresione Cualquier Tecla Para Regresar",205,205);
			system("pause>nul");
			break;
			
			//Se Termina el Programa
		case 0:
			system("cls");
			printf("\n\n\n\n\t\t\t        GRACIAS POR UTILIZAR!      ");
			system("pause>nul");//Para No Finalizar Enseguida
			repetir=false;
			exit(1);
			break;
			
		}
		
	}while(repetir);
	
}

//Funcion para Convertir de Cualquier Base a Decimal
long signed int BaseADecimal(long signed int NumEnt,long signed int Base1){
	
	//Declaracion de Variables
	long signed int NumAux,Valor=0,Aux,Pot=1;
	
	NumAux=NumEnt;///Bandera Auxiliar
	
	while(NumAux!=0){//Mientras EL Numero de Entrada sea Diferente de Cero se Descompone por Modulo Decimal y se Va Obteniendo el
		Aux=NumAux%10;
		NumAux=NumAux/10;
		Valor=Valor+Aux*Pot;
		Pot=Pot*Base1;
	}
	return Valor;//Devuelveme el Numero Convertido ya en Decimal
}

//Funcion Para Convertir de Decimal a Cualquier Base
long signed int DecimalABase(long signed int NumSal,long signed int Base2)
{
	long signed int Valor=0,Pot=1,NumAux,Aux;
	
	NumAux=NumSal;//Bandera Auxiliar
	
	while(NumAux!=0)//Mientras EL Numero de Entrada sea Diferente de Cero se Descompone por Modulo de la Base a Convertir
	{
		Aux=NumAux%Base2;
		NumAux=NumAux/Base2;
		Valor=Valor+Aux*Pot;
		Pot=Pot*10;
	}
	return Valor;
}
