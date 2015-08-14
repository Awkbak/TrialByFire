#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
	char line[17];
	int stats[2];
	stats[0] = 0;
	stats[1] = 0;
	char input[17];
	int winner = -1;
	fgets(input, 16, stdin);

	FILE *data;
	errno_t err;

	err = fopen_s(&data, "DATA.data", "r");

	if (err != 0) {
		fprintf(stderr, "Can't open input file!\n");
		exit(1);
	}
	while (fgets(line, 17, data) != NULL){
		if (strcmp(line, "S1\n") == 0){
			fgets(line, 15, data);
			if (line[2] == input[0]){
				fgets(line, 15, data);
				if (line[2] == input[2]){
					fgets(line, 15, data);
					if (line[2] == input[4]){
						fgets(line, 15, data);
						if (line[2] == input[6]){
							fgets(line, 15, data);
							if (line[4] == '1'){
								winner = 1;
							}
							else{
								winner = 0;
							}
							fgets(line, 15, data);
							fgets(line, 15, data);
							fgets(line, 15, data);
							if (line[2] == input[8]){
								fgets(line, 15, data);
								if (line[2] == input[10]){
									fgets(line, 15, data);
									if (line[2] == input[12]){
										fgets(line, 15, data);
										if (line[2] == input[14]){
											
											stats[0]++;
											if (winner){
												stats[1]++;
											}
										}
									}
								}
							}
						}
					}
				}
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