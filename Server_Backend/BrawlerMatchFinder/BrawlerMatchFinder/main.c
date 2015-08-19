#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
	char line[17];
	int stats[2];
	stats[0] = 0;
	stats[1] = 0;
	char input[22];
	fgets(input, 22, stdin);

	FILE *data;
	errno_t err;

	if (input[8] == 'N'){
		err = fopen_s(&data, "DATANA.data", "r");
	}
	else if (input[8] == 'B'){
		err = fopen_s(&data, "DATABR.data", "r");
	}
	else if (input[8] == 'K'){
		err = fopen_s(&data, "DATAKR.data", "r");
	}
	else if (input[8] == 'O'){
		err = fopen_s(&data, "DATAOCE.data", "r");
	}
	else if (input[8] == 'R'){
		err = fopen_s(&data, "DATARU.data", "r");
	}
	else if (input[8] == 'T'){
		err = fopen_s(&data, "DATATR.data", "r");
	}
	else if (input[8] == 'E'){
		if (input[10] == 'N'){
			err = fopen_s(&data, "DATAEUNE.data", "r");
		}
		else{
			err = fopen_s(&data, "DATAEUW.data", "r");
		}
	}
	else if (input[8] == 'L'){
		if (input[10] == 'N'){
			err = fopen_s(&data, "DATAELAN.data", "r");
		}
		else{
			err = fopen_s(&data, "DATALAS.data", "r");
		}
	}

	if (err != 0) {
		fprintf(stderr, "Can't open input file!\n");
		exit(1);
	}
	while (fgets(line, 17, data) != NULL){
		if (line[0] == input[0] && line[1] == input[1] && line[2] == input[2] && line[3] == input[3] && line[4] == input[4] && line[5] == input[5] && line[6] == input[6] && line[7] == input[7]){
			stats[0]++;
			if (line[8] == '1'){
				stats[1]++;
			}
		}
		else if (line[4] == input[0] && line[5] == input[1] && line[6] == input[2] && line[7] == input[3] && line[0] == input[4] && line[1] == input[5] && line[2] == input[6] && line[3] == input[7]){
			stats[0]++;
			if (line[8] == '2'){
				stats[1]++;
			}
		}
	}
	if (stats[0] == 0){
		printf("-1");
	}
	else{
		printf("%f", ((double)stats[1]) / stats[0]);
	}
}